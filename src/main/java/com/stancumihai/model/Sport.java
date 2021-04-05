package com.stancumihai.model;

public class Sport {

    private Long id;
    private String startPeriod;
    private String endPeriod;
    private String name;
    private Float price;

    public Sport() {
    }

    public Sport(String startPeriod, String endPeriod, String name, Float price) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.name = name;
        this.price = price;
    }

    public Sport(Long id, String startPeriod, String endPeriod, String name, Float price) {
        this.id = id;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(String startPeriod) {
        this.startPeriod = startPeriod;
    }

    public String getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(String endPeriod) {
        this.endPeriod = endPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", startPeriod='" + startPeriod + '\'' +
                ", endPeriod='" + endPeriod + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
