package com.example.locationfinder.helper;


import com.example.locationfinder.model.Location;

import java.awt.geom.Point2D;
import java.util.Comparator;
import java.util.List;

public class NearestLocationFinder {

    private Comparator<Location> distanceComparator = Comparator.comparing(location -> findDistance(location));
    private double latitude;
    private double longitude;

    public NearestLocationFinder(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String findName(List<Location> locations) {
        return locations
                .stream()
                .sorted(distanceComparator)
                .findFirst()
                .get()
                .getName();
    }

    private Double findDistance(Location location) {
        return Point2D.distance(latitude, longitude, location.getLatitude(), location.getLongtitude());
    }
}
