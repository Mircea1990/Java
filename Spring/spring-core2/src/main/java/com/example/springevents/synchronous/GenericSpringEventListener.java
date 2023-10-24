package com.example.springevents.synchronous;

import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

// The @Component annotation indicates that this class is a Spring component.
// Spring will automatically detect this class for dependency injection when component scanning
// is enabled.
@Component public class GenericSpringEventListener
        implements ApplicationListener<GenericSpringAppEvent<String>> {
    // A private boolean variable to check if the event handler was hit during testing
    private boolean hitEventHandler = false;

    // This method is invoked when an ApplicationEvent is published.
    // The @NonNull annotation ensures that the event object is not null.
    @Override public void onApplicationEvent(@NonNull final GenericSpringAppEvent<String> event) {
        // Print the event detail to the console
        System.out.println("Received spring generic event - " + event.getWhat());
        // Set the hitEventHandler to true indicating that this method was hit
        hitEventHandler = true;
    }

    // A getter method for the hitEventHandler variable
    boolean isHitEventHandler() {
        return hitEventHandler;
    }
}
