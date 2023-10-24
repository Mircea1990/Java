package com.example.getbean;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// This annotation is used to control the lifecycle of test instances. Here, it's set to
// PER_CLASS which means a new test instance will be created once per test class.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GetBeanByNameWithConstructorParametersUnitTest {
    // Declaring a private variable of type ApplicationContext which is the central interface
    // within a Spring application for providing configuration information to the application.
    private ApplicationContext context;

    // This method will be executed before all tests. It sets up the application context with the
    // configuration from AnnotationConfig class.
    @BeforeAll void setup() {
        context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
    }

    // This test case checks if the bean with name 'tiger' and constructor parameter 'Siberian'
    // exists in the application context. If it does, it checks if the name of the tiger is
    // 'Siberian'.
    @Test void whenGivenCorrectName_thenShouldReturnBeanWithSpecifiedName() {
        Tiger tiger = (Tiger) context.getBean("tiger", "Siberian");
        assertEquals("Siberian", tiger.getName());
    }

    // This test case checks if the beans with name 'tiger' and constructor parameters 'Siberian'
    // and 'Striped' exist in the application context. If they do, it checks if the names of the
    // tigers are 'Siberian' and 'Striped' respectively.
    @Test void whenGivenCorrectNameOrAlias_shouldReturnBeanWithSpecifiedName() {
        Tiger tiger = (Tiger) context.getBean("tiger", "Siberian");
        Tiger secondTiger = (Tiger) context.getBean("tiger", "Striped");
        assertEquals("Siberian", tiger.getName());
        assertEquals("Striped", secondTiger.getName());
    }

    // This test case tries to get a bean with name 'tiger' without specifying any constructor
    // parameters. Since 'tiger' is a prototype bean that requires constructor parameters, it
    // should throw an UnsatisfiedDependencyException.
    @Test void whenNoArgumentSpecifiedForPrototypeBean_thenShouldThrowException() {
        assertThrows(UnsatisfiedDependencyException.class, () -> {
            Tiger tiger = (Tiger) context.getBean("tiger");
        });
    }
}

