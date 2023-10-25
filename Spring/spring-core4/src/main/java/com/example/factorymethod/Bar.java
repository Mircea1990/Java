package com.example.factorymethod;

import lombok.Getter;

// The @Getter annotation from Lombok library generates a getter for all non-static fields.
@Getter public class Bar {
    // A private field 'name' of type String. It can only be accessed within this class.
    private String name;

    // This is a constructor for the Bar class that takes a String argument.
    // It initializes the 'name' field with the provided argument.
    public Bar(String name) {
        this.name = name;
    }

    // This is a setter method for the 'name' field.
    // It allows to update the value of 'name' from outside this class.
    public void setName(String name) {
        this.name = name;
    }
}

