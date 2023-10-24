package com.example.springevents.synchronous;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

// Indicate that this class is a Spring component
@Component public class ContextRefreshedListener
        implements ApplicationListener<ContextRefreshedEvent> {
    // Variable to track if the event handler was hit, mainly for testing purposes
    private boolean hitContextRefreshedHandler = false;

    // Override the onApplicationEvent method from the ApplicationListener interface
    @Override public void onApplicationEvent(final ContextRefreshedEvent cse) {
        // Print a message to the console when the context refreshed event is handled
        System.out.println("Handling context re-freshed event. ");
        // Set the flag to true indicating this handler was hit
        hitContextRefreshedHandler = true;
    }

    // Getter method for the flag
    boolean isHitContextRefreshedHandler() {
        return hitContextRefreshedHandler;
    }
}
