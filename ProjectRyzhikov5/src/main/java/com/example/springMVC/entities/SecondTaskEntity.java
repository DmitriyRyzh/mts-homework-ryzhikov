package com.example.springMVC.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SecondTaskEntity {

    private String name;

    public SecondTaskEntity(String name) {
        this.name = name;
    }

    public SecondTaskEntity() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
