package com.example.spring43.ctor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation indicates that this class declares one or more @Bean methods and
// may be processed by the Spring container to generate bean definitions and service requests for
// those beans at runtime.
@Configuration public class FooServiceConfiguration {

    // This is a private final variable of type FooRepository. It's final because once assigned,
    // it cannot be changed. It's a dependency of FooServiceConfiguration.
    private final FooRepository repository;

    // This is the constructor of FooServiceConfiguration. It takes an instance of FooRepository
    // as an argument. This is where Dependency Injection happens if you're using Spring
    // Framework. The repository is injected when an instance of FooServiceConfiguration is created.
    public FooServiceConfiguration(FooRepository repository) {
        this.repository = repository;
    }

    // The @Bean annotation tells Spring that this method will return an object that should be
    // registered as a bean in the Spring application context. The body of the method creates a
    // new instance of FooService, passing the repository to its constructor.
    @Bean public FooService fooService() {
        return new FooService(this.repository);
    }
}

