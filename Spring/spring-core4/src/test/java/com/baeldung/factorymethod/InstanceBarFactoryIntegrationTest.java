package com.baeldung.factorymethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.factorymethod.Bar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// This annotation tells JUnit to run the test using Spring's testing support.
// SpringJUnit4ClassRunner is a custom extension of JUnit's BlockJUnit4ClassRunner which provides
// functionality of the Spring TestContext Framework to standard JUnit tests.
@RunWith(SpringJUnit4ClassRunner.class)

// This annotation is used to specify the locations of configuration files to load for this test
// class. Here, it's loading an XML configuration file from a specified path.
@ContextConfiguration("/factorymethod/instance-bar-config.xml")

// This is the test class for the instance factory method
public class InstanceBarFactoryIntegrationTest {

    // This annotation is used for automatic dependency injection. Here, it's injecting an
    // instance of Bar.
    @Autowired private Bar instance;

    // This is a test method
    @Test public void givenValidInstanceFactoryConfig_whenCreateInstance_thenNameIsCorrect() {
        // This assertion checks if the instance is not null, meaning it has been properly
        // initialized
        assertNotNull(instance);

        // This assertion checks if the name of the instance is correct as per the expectation
        assertEquals("someName", instance.getName());
    }
}

