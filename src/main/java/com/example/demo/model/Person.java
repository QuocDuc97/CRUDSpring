package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private UUID id;
    private String fullname;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
