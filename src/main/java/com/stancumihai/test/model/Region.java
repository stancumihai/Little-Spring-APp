package com.stancumihai.test.model;

public class Region extends Location{

    private long id;
    private Location location;

    public Region() {
    }

    public Region(Location location) {
        this.location = location;
    }

    public Region(long id, Location location) {
        this.id = id;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "Region{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
