package com.example.spring.patterns.factory;

import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// This annotation is from Lombok and it generates a getter method for all non-final fields
@Getter
// This annotation is from Spring and it marks this class as a bean so it can be auto-detected in
// component scanning
@Component
// This annotation is also from Spring and it sets the scope of the bean to prototype, meaning a
// new instance will be created every time the bean is requested
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) public class Bar {
    // A private field to hold the name
    private final String name;

    // Constructor that initializes the name field
    public Bar(String name) {
        this.name = name;
    }
}
