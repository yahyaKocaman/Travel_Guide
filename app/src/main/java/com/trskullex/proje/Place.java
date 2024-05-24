package com.trskullex.proje;

import java.io.Serializable;

public class Place implements Serializable {
    private int imageResourceId;
    private String name;
    private String description;
    private String location;
    private double latitude;
    private double longitude;

    public Place(int imageResourceId, String name, String description, String location, double latitude, double longitude) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
