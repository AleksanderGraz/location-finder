package com.example.locationfinder.mapper;

import com.example.locationfinder.model.Location;
import com.example.locationfinder.model.LocationRest;

public class LocationMapper {

    public LocationRest mapFromDomainObject(Location location) {
        LocationRest result = new LocationRest();
        result.setLatitude(location.getLatitude());
        result.setLongitude(location.getLongtitude());
        result.setName(location.getName());
        result.setId(location.getId());
        return result;
    }

    public Location mapToDomainObject(LocationRest locationRest){
        Location result = new Location();
        result.setLatitude(locationRest.getLatitude());
        result.setLongitude(locationRest.getLongitude());
        result.setName(locationRest.getName());
        result.setId(locationRest.getId());
        return result;
    }
}
