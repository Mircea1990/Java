package com.example.spring.patterns.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// The @RestController annotation is used to define a controller for RESTful web services.
@RestController public class BookController {
    // The @Autowired annotation is used for automatic dependency injection.
    // Here, it's injecting an instance of BookManager into this controller.
    @Autowired private BookManager manager;

    // The @PostMapping annotation is used to map HTTP POST requests onto specific handler methods.
    // Here, it's mapping any POST requests sent to "/book" to the create() method.
    @PostMapping("/book") public Book create(@RequestParam String author) {
        // The create() method takes an author name as a parameter and uses the manager to create
        // a new book with that author.
        // It then returns the newly created Book object.
        return manager.create(author);
    }
}

