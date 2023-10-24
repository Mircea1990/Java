package com.example.scopes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopesIntegrationTest {
    // Constants for names
    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    // This test method checks if two beans of singleton scope share the same state
    @Test public void givenSingletonScope_whenSetName_thenEqualNames() {
        // Load the Spring context from the XML configuration file
        final AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "scopes.xml");
        // Get the singleton beans from the context
        final Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
        final Person personSingletonB = (Person) applicationContext.getBean("personSingleton");
        // Set the name of the first singleton bean
        personSingletonA.setName(NAME);
        // Assert that the name of the second singleton bean is equal to the name set for the
        // first bean
        Assertions.assertEquals(NAME, personSingletonB.getName());
        // Close the application context
        applicationContext.close();
    }

    // This test method checks if two beans of prototype scope have different states
    @Test public void givenPrototypeScope_whenSetNames_thenDifferentNames() {
        // Load the Spring context from the XML configuration file
        final AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "scopes.xml");
        // Get the prototype beans from the context
        final Person personPrototypeA = (Person) applicationContext.getBean("personPrototype");
        final Person personPrototypeB = (Person) applicationContext.getBean("personPrototype");
        // Set different names for the prototype beans
        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);
        // Assert that each prototype bean has its own state (name)
        Assertions.assertEquals(NAME, personPrototypeA.getName());
        Assertions.assertEquals(NAME_OTHER, personPrototypeB.getName());
        // Close the application context
        applicationContext.close();
    }
}

