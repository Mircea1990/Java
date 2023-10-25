package com.example.spring43.ctor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation is used to indicate that this class declares one or more @Bean
// methods
// and may be processed by the Spring container to generate bean definitions and service requests
// for those beans at runtime.
@Configuration public class FooRepositoryConfiguration {

    // The @Bean annotation is used to indicate that a method produces a bean to be managed by
    // the Spring container.
    // In this case, it's creating a new instance of FooRepository.
    @Bean public FooRepository fooRepository() {
        // Here we are returning a new instance of FooRepository.
        // This instance will be managed by Spring and can be injected into other components as
        // needed.
        return new FooRepository();
    }
}

