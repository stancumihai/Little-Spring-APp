package com.stancumihai.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SportLocations {

    private Long id;
    private Sport sport;
    private Location location;

    public SportLocations() {
    }

    public SportLocations(Sport sport, Location location) {
        this.sport = sport;
        this.location = location;
    }

    public SportLocations(Long id, Sport sport, Location location) {
        this.id = id;
        this.sport = sport;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "SportLocation{" +
                "sport=" + sport +
                ", location=" + location +
                '}';
    }
}
