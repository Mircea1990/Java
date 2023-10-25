package com.example.spring43.defaultmethods;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;

// This annotation is used to specify the XML file that contains the Spring configuration.
@ContextConfiguration("classpath:defaultmethods-context.xml")

// This class is a test class that extends AbstractJUnit4SpringContextTests,
// which is a convenient base class for JUnit 4.12+ tests that need to test something involving
// Spring components.
public class DefaultMethodsInjectionIntegrationTest extends AbstractJUnit4SpringContextTests {

    // The @Autowired annotation is used by Spring to automatically inject an instance of
    // IDateHolder into this field.
    @Autowired private IDateHolder dateHolder;

    // This is a test method annotated with @Test. The purpose of this test is to check if the
    // injection of
    // the default interface method has happened correctly.
    @Test public void whenInjectingToDefaultInterfaceMethod_thenInjectionShouldHappen() {
        // Here, it's asserting that the date returned by dateHolder.getLocalDate() should be
        // equal to LocalDate.of(1982, 10, 15).
        assertEquals(LocalDate.of(1982, 10, 15), dateHolder.getLocalDate());
    }
}

