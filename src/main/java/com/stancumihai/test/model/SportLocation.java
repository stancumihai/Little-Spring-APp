package com.stancumihai.test.model;

public class SportLocation {

    private Sport sport;
    private Location location;

    public SportLocation(Sport sport, Location location) {
        this.sport = sport;
        this.location = location;
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
