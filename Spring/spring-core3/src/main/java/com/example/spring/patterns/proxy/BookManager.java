package com.example.spring.patterns.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// The @Service annotation is used to indicate that the class provides some business
// functionalities.
@Service public class BookManager {
    // The @Autowired annotation is used for automatic dependency injection.
    // Here, it's injecting an instance of BookRepository into this service.
    @Autowired private BookRepository repository;

    // The @Transactional annotation is used to ensure that the method is executed within a
    // transaction scope.
    // That means each create operation will be executed in a single transaction.
    @Transactional public Book create(String author) {
        // Print the class name of the repository instance to the console.
        System.out.println(repository.getClass().getName());
        // Call the create method of the repository with the given author and return the result.
        return repository.create(author);
    }
}

