package com.example.spring.patterns.proxy;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate the getter methods for your
// fields.
@Getter
// This is your class named 'Book'.
public class Book {
    // This is a private final field 'author' for the class 'Book'.
    private final String author;

    // This is the constructor of the class 'Book' which takes a String 'author' as parameter.
    public Book(String author) {
        this.author = author;
    }
}

