package com.stancumihai.model;

public class Region extends Location{

    private Long id;
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
        return "Region{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
