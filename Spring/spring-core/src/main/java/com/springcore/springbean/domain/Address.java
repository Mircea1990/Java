package com.springcore.springbean.domain;

import lombok.Data;

// The @Data annotation is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
@Data
public class Address {
    // A private String variable to hold the street name
    private String street;
    // A private integer variable to hold the street number
    private int number;

    // This is a constructor for the Address class that initializes the street name and number
    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
}

