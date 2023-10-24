package com.example.spring.patterns.template;

import lombok.Getter;

// The @Getter annotation from Lombok library generates getter methods for all fields.
@Getter public class Book {
    // A private field to hold the id of the book.
    private long id;
    // A private field to hold the title of the book.
    private String title;
    // A private field to hold the author of the book.
    private String author;

    // Setter method for the 'id' field.
    public void setId(long id) {
        this.id = id;
    }

    // Setter method for the 'title' field.
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter method for the 'author' field.
    public void setAuthor(String author) {
        this.author = author;
    }
}

