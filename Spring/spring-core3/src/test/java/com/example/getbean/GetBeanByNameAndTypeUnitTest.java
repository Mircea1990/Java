package com.example.getbean;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// This annotation is used to control the lifecycle of test instances. Here, it's set to
// PER_CLASS which means a new test instance will be created once per test class.
@TestInstance(TestInstance.Lifecycle.PER_CLASS) class GetBeanByNameAndTypeUnitTest {
    // Declaring a private variable of type ApplicationContext which is the central interface
    // within a Spring application for providing configuration information to the application.
    private ApplicationContext context;

    // This method will be executed before all tests. It sets up the application context with the
    // configuration from AnnotationConfig class.
    @BeforeAll void setup() {
        context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
    }

    // This test case checks if the bean with name 'lion' and type Lion.class exists in the
    // application context. If it does, it checks if the name of the lion is 'Hardcoded lion name'.
    @Test void whenSpecifiedMatchingNameAndType_thenShouldReturnRelatedBean() {
        Lion lion = context.getBean("lion", Lion.class);
        assertEquals("Hardcoded lion name", lion.getName());
    }

    // This test case checks if the bean with name 'lion' and type Tiger.class exists in the
    // application context. Since it doesn't, it should throw a BeanNotOfRequiredTypeException.
    @Test void whenSpecifiedNotMatchingNameAndType_thenShouldThrowException() {
        assertThrows(BeanNotOfRequiredTypeException.class,
                     () -> context.getBean("lion", Tiger.class));
    }
}

