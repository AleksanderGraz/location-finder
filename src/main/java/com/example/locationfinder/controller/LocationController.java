package com.example.locationfinder.controller;

import com.example.locationfinder.model.LocationRest;
import com.example.locationfinder.service.LocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({"/location"})
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    LocationRest create(@RequestBody LocationRest locationRest) {
        return locationService.create(locationRest);
    }

    @GetMapping("/latitude/{latitude}/longitude/{longitude}")
    String findNearestLocationName(@PathVariable double latitude, @PathVariable double longitude) {
        return locationService.findNearestLocationName(latitude, longitude);
    }
}
