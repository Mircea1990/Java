package com.example.getbean;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

// This annotation specifies that the test instance lifecycle is per class.
// This means a new test instance will be created once per test class.
@TestInstance(TestInstance.Lifecycle.PER_CLASS) class GetBeanByTypeUnitTest {
    // Declaring a private ApplicationContext variable named 'context'.
    private ApplicationContext context;

    // This method will be executed before all tests. It sets up the application context.
    @BeforeAll void setup() {
        // Initializing the 'context' with an instance of AnnotationConfigApplicationContext.
        context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
    }

    // This test checks if a bean of type Lion exists in the application context.
    @Test void whenGivenExistingUniqueType_thenShouldReturnRelatedBean() {
        // Getting the bean of type Lion from the application context.
        Lion lion = context.getBean(Lion.class);
        // Asserting that the lion object is not null, i.e., a bean of type Lion exists.
        assertNotNull(lion);
    }

    // This test checks if an exception is thrown when there are multiple beans of the same type.
    @Test void whenGivenAmbiguousType_thenShouldThrowException() {
        // Asserting that getting a bean of type Animal throws NoUniqueBeanDefinitionException,
        // i.e., there are multiple beans of type Animal in the application context.
        assertThrows(NoUniqueBeanDefinitionException.class,
                     () -> context.getBean(AnnotationConfig.Animal.class));
    }
}

