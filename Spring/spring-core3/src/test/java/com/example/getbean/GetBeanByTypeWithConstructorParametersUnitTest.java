package com.example.getbean;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This annotation specifies that the test instance lifecycle is per class.
// This means a new test instance will be created once per test class.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetBeanByTypeWithConstructorParametersUnitTest {
    // Declaring a private ApplicationContext variable named 'context'.
    private ApplicationContext context;

    // This method will be executed before all tests. It sets up the application context.
    @BeforeAll void setup() {
        // Initializing the 'context' with an instance of AnnotationConfigApplicationContext.
        context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
    }

    // This test checks if a bean of type Tiger exists in the application context and can be
    // created with valid parameters.
    @Test void whenGivenExistingTypeAndValidParameters_thenShouldReturnRelatedBean() {
        // Getting the bean of type Tiger from the application context with "Shere Khan" as a
        // constructor parameter.
        Tiger tiger = context.getBean(Tiger.class, "Shere Khan");
        // Asserting that the name of the tiger object is "Shere Khan".
        assertEquals("Shere Khan", tiger.getName());
    }
}

