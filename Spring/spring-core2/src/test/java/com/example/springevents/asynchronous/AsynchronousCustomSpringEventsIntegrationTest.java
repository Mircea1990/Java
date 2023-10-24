package com.example.springevents.asynchronous;

import com.example.springevents.synchronous.CustomSpringEventPublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

// This class is a test class that uses SpringJUnit4ClassRunner to run tests within the Spring
// ApplicationContext
@RunWith(SpringJUnit4ClassRunner.class)
// This annotation is used to specify which classes to use for loading the application context
@ContextConfiguration(classes = {AsynchronousSpringEventsConfig.class},
                      loader = AnnotationConfigContextLoader.class)
public class AsynchronousCustomSpringEventsIntegrationTest {
    // Autowired instance of CustomSpringEventPublisher
    @Autowired private CustomSpringEventPublisher publisher;

    // This test method checks if the custom event is published correctly
    @Test public void testCustomSpringEvents() throws InterruptedException {
        // Publish a custom event with the message "Hello world!!"
        publisher.publishCustomEvent("Hello world!!");
        // Print a message indicating that the custom event has been published
        System.out.println("Done publishing asynchronous custom event. ");
    }
}

