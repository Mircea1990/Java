package com.example.springevents.synchronous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

// The @Component annotation marks this class as a component in the Spring Framework.
// This means that Spring will automatically detect this class for dependency injection.
@Component
public class CustomSpringEventPublisher {
    // The @Autowired annotation allows Spring to resolve and inject collaborating beans into our bean.
    // Here it's injecting an ApplicationEventPublisher.
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    // This method is used to publish a CustomSpringEvent.
    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event. ");
        // It creates a new CustomSpringEvent with the provided message.
        final CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        // It publishes the event to the application context.
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

    // This method is used to publish a GenericSpringEvent.
    public void publishGenericEvent(final String message, boolean success) {
        System.out.println("Publishing generic event.");
        // It creates a new GenericSpringEvent with the provided message and success flag.
        final GenericSpringEvent<String> genericSpringEvent = new GenericStringSpringEvent(message, success);
        // It publishes the event to the application context.
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }

    // This method is used to publish a GenericSpringAppEvent.
    public void publishGenericAppEvent(final String message) {
        System.out.println("Publishing generic event.");
        // It creates a new GenericSpringAppEvent with the provided message.
        final GenericSpringAppEvent<String> genericSpringEvent = new GenericStringSpringAppEvent(this, message);
        // It publishes the event to the application context.
        applicationEventPublisher.publishEvent(genericSpringEvent);
    }
}

