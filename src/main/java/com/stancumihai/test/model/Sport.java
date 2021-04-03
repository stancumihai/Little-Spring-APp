package com.stancumihai.test.model;

public class Sport {

    private Long id;
    private String period;
    private String name;

    public Sport() {
    }

    public Sport(String period, String name) {
        this.period = period;
        this.name = name;
    }

    public Sport(Long id, String period, String name) {
        this.id = id;
        this.period = period;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", period='" + period + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
