package com.example.spring43.ctor;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
@Getter public class FooService {

    // An instance of FooRepository to handle operations related to Foo objects in the database.
    private final FooRepository repository;

    // Constructor for the FooService class.
    // It initializes the repository field with the provided FooRepository instance.
    public FooService(FooRepository repository) {
        this.repository = repository;
    }
}
