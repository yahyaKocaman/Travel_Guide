package com.trskullex.projem;

import java.io.Serializable;

public class Place implements Serializable {
    private int imageResourceId; // Yer görselinin kaynak IDsi
    private String name; // Yer ismi
    private String description; // Yer açıklaması
    private String location; // Yer konumu
    private double latitude; // Yer enlemi
    private double longitude; // Yer boylamı

    // consturactorum
    public Place(int imageResourceId, String name, String description, String location, double latitude, double longitude) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Yer görselinin kaynak IDsi
    public int getImageResourceId() {
        return imageResourceId;
    }

    // Yer ismi
    public String getName() {
        return name;
    }

    // Yer açıklaması
    public String getDescription() {
        return description;
    }

    // Yer konumu
    public String getLocation() {
        return location;
    }

    // Yer enlemi
    public double getLatitude() {
        return latitude;
    }

    // Yer boylamı
    public double getLongitude() {
        return longitude;
    }
}
