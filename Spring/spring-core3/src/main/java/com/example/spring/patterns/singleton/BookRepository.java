package com.example.spring.patterns.singleton;

import org.springframework.stereotype.Repository;

import java.util.Optional;

// The @Repository annotation is used to indicate that the class provides the mechanism for
// storage, retrieval,
// search, update and delete operation on objects.
@Repository public class BookRepository {
    // The count method returns the total number of books in the repository.
    // Here, it's hardcoded to return 1.
    public long count() {
        return 1;
    }

    // The findById method takes a book id as a parameter and returns an Optional of the Book
    // object.
    // Here, it's hardcoded to return an Optional of a new Book object.
    public Optional<Book> findById(long id) {
        return Optional.of(new Book());
    }
}

