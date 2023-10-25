package com.example.factorymethod;

import static org.junit.Assert.assertNotNull;

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
@ContextConfiguration("/factorymethod/instance-foo-config.xml")

// This is the test class for the instance factory method
public class InstanceFooFactoryIntegrationTest {

    // This annotation is used for automatic dependency injection. Here, it's injecting an
    // instance of Foo.
    @Autowired private Foo foo;

    // This is a test method
    @Test
    public void givenValidInstanceFactoryConfig_whenCreateFooInstance_thenInstanceIsNotNull() {
        // This assertion checks if the foo instance is not null, meaning it has been properly
        // initialized
        assertNotNull(foo);
    }
}

