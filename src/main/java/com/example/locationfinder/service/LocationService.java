package com.example.locationfinder.service;


import com.example.locationfinder.exception.EntityNotFoundException;
import com.example.locationfinder.helper.NearestLocationFinder;
import com.example.locationfinder.mapper.LocationMapper;
import com.example.locationfinder.model.Location;
import com.example.locationfinder.model.LocationRest;
import com.example.locationfinder.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper mapper = new LocationMapper();

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationRest create(LocationRest locationRest) {
        Location location = locationRepository.save(mapper.mapToDomainObject(locationRest));
        return mapper.mapFromDomainObject(location);
    }

    public String findNearestLocationName(double currentLatitude, double currentLongitude) {
        List<Location> locations = locationRepository.findAll();
        if(locations.isEmpty()){
            throw new EntityNotFoundException("No locations in database");
        }
        NearestLocationFinder nearestLocationFinder = new NearestLocationFinder(currentLatitude, currentLongitude);
        return nearestLocationFinder.findName(locations);
    }
}
