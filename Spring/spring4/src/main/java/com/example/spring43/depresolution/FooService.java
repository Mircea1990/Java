package com.example.spring43.depresolution;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

// This is a public class named FooService, annotated with @Service and @Getter.
// @Service annotation is used to indicate that it's a service component in the Spring framework.
// @Getter annotation from Lombok library automatically generates getter methods for all fields.
@Getter @Service public class FooService {
    // A private final instance variable named repository of type FooRepository.
    // This variable is used to interact with the data layer.
    private final FooRepository repository;

    // This is a public constructor for the FooService class.
    // It takes an ObjectProvider of FooRepository as a parameter. ObjectProvider is a factory
    // for obtaining instances/beans of a certain type.
    // The getIfUnique() method returns the FooRepository bean if it's unique; otherwise, it
    // returns null.
    public FooService(ObjectProvider<FooRepository> repositoryProvider) {
        this.repository = repositoryProvider.getIfUnique();
    }
}

