package com.springcore.applicationcontext;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate the getter methods for all
// fields in the class.
@Getter public class Course {
    // A private field 'name' for the Course class.
    private String name;

    // A no-argument constructor for the Course class.
    public Course() {
    }

    // A constructor for the Course class that takes a 'name' argument.
    public Course(String name) {
        this.name = name;
    }

    // A setter method to set the 'name' field of the Course class.
    public void setName(String name) {
        this.name = name;
    }
}

