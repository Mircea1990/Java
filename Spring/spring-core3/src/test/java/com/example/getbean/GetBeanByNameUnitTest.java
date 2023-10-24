package com.example.getbean;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// This annotation is used to control the lifecycle of test instances. Here, it's set to
// PER_CLASS which means a new test instance will be created once per test class.
@TestInstance(TestInstance.Lifecycle.PER_CLASS) class GetBeanByNameUnitTest {
    // Declaring a private variable of type ApplicationContext which is the central interface
    // within a Spring application for providing configuration information to the application.
    private ApplicationContext context;

    // This method will be executed before all tests. It sets up the application context with the
    // configuration from AnnotationConfig class.
    @BeforeAll void setup() {
        context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
    }

    // This test case checks if the bean with name 'lion' exists in the application context. If
    // it does, it checks if the class of the bean is Lion.class.
    @Test void whenGivenExistingBeanName_shouldReturnThatBean() {
        Object lion = context.getBean("lion");
        assertEquals(lion.getClass(), Lion.class);
    }

    // This test case checks if a bean with name 'non-existing' exists in the application context
    // . Since it doesn't, it should throw a NoSuchBeanDefinitionException.
    @Test void whenGivenNonExistingBeanName_shouldThrowException() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("non-existing"));
    }

    // This test case tries to cast a bean with name 'lion' to Tiger.class. Since 'lion' is of
    // type Lion.class, it should throw a ClassCastException.
    @Test void whenCastingToWrongType_thenShouldThrowException() {
        assertThrows(ClassCastException.class, () -> {
            Tiger tiger = (Tiger) context.getBean("lion");
        });
    }
}
