package com.example.spring.patterns.proxy;

import org.springframework.stereotype.Repository;

// The @Repository annotation is used to indicate that the class provides the mechanism for
// storage, retrieval,
// search, update and delete operation on objects.
@Repository public class BookRepository {
    // The create method takes an author name as a parameter, creates a new Book object with that
    // author,
    // and then returns the newly created Book object.
    public Book create(String author) {
        return new Book(author);
    }
}

