package com.stancumihai.model;

public class Location {

    private Long id;
    private String name;

    public Location() {

    }

    public Location(String name, String country) {
        this.name = name;
         ;
    }

    public Location(Long id, String name ) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
