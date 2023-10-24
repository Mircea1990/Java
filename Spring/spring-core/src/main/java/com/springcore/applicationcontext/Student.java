package com.springcore.applicationcontext;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
@Getter
public class Student {
    // Represents the number of the student
    private int no;
    // Represents the name of the student
    private String name;

    // Constructor to initialize a new Student with number and name
    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    // Setter method to update the number of this student
    public void setNo(int no) {
        this.no = no;
    }

    // Setter method to update the name of this student
    public void setName(String name) {
        this.name = name;
    }

    // Method to destroy a student object and print a message
    public void destroy() {
        System.out.println("Student(no: " + no + ") is destroyed");
    }
}

