package com.stancumihai.test.model;

public class Country extends Location{

    private Long id;
    private Location location;


    public Country() {
    }

    public Country(Location location) {
        this.location = location;
    }

    public Country(Long id, Location location) {
        this.id = id;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
