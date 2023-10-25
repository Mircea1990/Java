package com.example.jsonp.model;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate getters for all fields in the
// class.
@Getter public class Company {
    // Declare a private long field 'id'.
    private long id;
    // Declare a private String field 'name'.
    private String name;

    // Default constructor for the Company class. Calls the superclass constructor.
    public Company() {
        super();
    }

    // Parameterized constructor for the Company class. Initializes 'id' and 'name' with given
    // values.
    public Company(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    // Setter method for 'name'. Sets the value of 'name' to the given input.
    public void setName(final String name) {
        this.name = name;
    }

    // Setter method for 'id'. Sets the value of 'id' to the given input.
    public void setId(final long id) {
        this.id = id;
    }

    // Override the toString method from the Object class.
    // Returns a string representation of the object, in this case "Company [id=" + id + ",
    // name=" + name + "]".
    @Override public String toString() {
        return "Company [id=" + id + ", name=" + name + "]";
    }
}

