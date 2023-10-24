package com.example.spring.patterns.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// The @RestController annotation is used to define a controller for RESTful web services.
@RestController public class LibraryController {
    // The @Autowired annotation is used for automatic dependency injection.
    // Here, it's injecting an instance of BookRepository into this controller.
    @Autowired private BookRepository repository;

    // The @GetMapping annotation maps HTTP GET requests onto specific handler methods.
    // Here, it's mapping any GET requests sent to "/count" to the findCount() method.
    @GetMapping("/count") public Long findCount() {
        // This line prints the repository instance to the console.
        System.out.println(repository);
        // The count() method returns the total number of books in the repository.
        // The result is returned as the response body.
        return repository.count();
    }
}

