package com.example.springevents.synchronous;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// The @Component annotation marks this class as a component in the Spring Framework.
// This means that Spring will automatically detect this class for dependency injection.
@Component
// CustomSpringEventListener is a class that implements the ApplicationListener interface from
// the Spring Framework.
// It's designed to handle CustomSpringEvent events.
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {
    // This method is called when an CustomSpringEvent is published.
    @Override public void onApplicationEvent(final CustomSpringEvent event) {
        // It prints the message from the received event to the console.
        System.out.println("Received spring custom event - " + event.getMessage());
    }
}
