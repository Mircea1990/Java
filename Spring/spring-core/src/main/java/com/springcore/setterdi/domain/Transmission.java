package com.springcore.setterdi.domain;

// This is a public class named Transmission
public class Transmission {
    // A private instance variable 'type' of String type
    private String type;

    // A public constructor with no parameters
    public Transmission() {
    }

    // A public method 'setType' which sets the value of 'type'
    public void setType(String type) {
        this.type = type;
    }

    // Overriding the toString method from the Object class
    @Override public String toString() {
        // Returns a formatted string representing 'type'
        return String.format("%s", type);
    }
}

