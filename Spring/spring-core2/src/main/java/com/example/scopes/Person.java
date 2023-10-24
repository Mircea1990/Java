package com.example.scopes;

import lombok.Getter;

// The class Person represents a person with a name and age
public class Person {
    // The @Getter annotation is used to generate a getter method for the field
    @Getter
    // name is a private String that will store the name of the person
    private String name;
    // age is a private integer that will store the age of the person
    private int age;

    // Default constructor for the Person class
    public Person() {
    }

    // Constructor for the Person class which takes a name and an age as inputs
    public Person(final String name, final int age) {
        this.name = name;
        // Note: The age field is not set in this constructor
    }

    // Setter method for the name field
    public void setName(final String name) {
        this.name = name;
    }

    // Overriding the toString method to provide a custom string representation of the object
    @Override public String toString() {
        return "Person [name=" + name + "]";
    }
}

