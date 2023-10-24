package com.example.spring.patterns.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// The @RestController annotation is used to define a controller for RESTful web services.
@RestController public class BookController {
    // The @Autowired annotation is used for automatic dependency injection.
    // Here, it's injecting an instance of BookRepository into this controller.
    @Autowired private BookRepository repository;

    // The @GetMapping annotation is used to map HTTP GET requests onto specific handler methods.
    // Here, it's mapping any GET requests sent to "/book/{id}" to the findById() method.
    @GetMapping("/book/{id}") public Book findById(@PathVariable long id) {
        // Print the repository instance to the console.
        System.out.println(repository);
        // Call the findById method of the repository with the given id and return the result.
        // The get() method is called on the Optional returned by findById() to get the Book object.
        return repository.findById(id).get();
    }
}

