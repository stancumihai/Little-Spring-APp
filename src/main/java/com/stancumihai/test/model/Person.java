package com.stancumihai.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Person {

    private static Long increment = 1L;
    private Long id;

    private String name;

    public Person() {
    }

    public Person(@JsonProperty("name") String name) {
        setId(increment++);

        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
