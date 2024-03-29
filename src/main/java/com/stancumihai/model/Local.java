package com.stancumihai.model;


public class Local extends Location {

    private Long id;
    private Location location;

    public Local() {
    }

    public Local(Long id, Location location) {
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
        return "Local{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }
}
