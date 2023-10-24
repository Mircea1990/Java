package com.example.beanfactory;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate getters for all fields in the
// class.
@Getter public class Employee {
    // The age of the employee. This is a final field, meaning that it can only be set once and
    // cannot be changed after it is set.
    private final int age;
    // The name of the employee. This can be changed using the setName method.
    private String name;

    // This is the constructor for the Employee class. It initializes the name and age of the
    // employee.
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // This method sets the name of the employee.
    public void setName(String name) {
        this.name = name;
    }
}

