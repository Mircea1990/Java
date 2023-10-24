package com.example.getbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// The @Configuration annotation indicates that this class declares one or more @Bean methods and
// may be processed by the Spring container to generate bean definitions and service requests for
// those beans at runtime.
@Configuration class AnnotationConfig {
    // The @Bean annotation tells Spring that this method will return an object that should be
    // registered as a bean in the Spring application context. The bean's name will be "tiger"
    // and "kitty".
    // The @Scope annotation defines the scope of the beans created from the getTiger() method to
    // be prototype, meaning a new instance will be created every time the bean is requested.
    @Bean(name = {"tiger", "kitty"}) @Scope(value = "prototype") Tiger getTiger(String name) {
        return new Tiger(name); // Creates a new Tiger object with the provided name.
    }

    // This method is annotated with @Bean, meaning it will return an object that should be
    // registered as a bean in the Spring application context. The bean's name will be "lion".
    @Bean(name = "lion") Lion getLion() {
        return new Lion("Hardcoded lion name"); // Creates a new Lion object with a hardcoded name.
    }

    // This is an interface declaration for Animal. It can be implemented by classes that
    // represent different types of animals.
    interface Animal {}
}

