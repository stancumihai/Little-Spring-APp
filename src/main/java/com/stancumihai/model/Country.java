package com.stancumihai.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Country extends Location {

    @JsonSerialize(using = CustomSerializer.class)
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
