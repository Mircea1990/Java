package com.example.springevents.synchronous;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

// Indicate that this class is a Spring component
@Component public class AnnotationDrivenEventListener {
    // Variables to track if the event handlers were hit, mainly for testing purposes
    private boolean hitContextStartedHandler = false;
    private boolean hitSuccessfulEventHandler = false;
    private boolean hitCustomEventHandler = false;

    // Event listener for the ContextStartedEvent
    @EventListener public void handleContextStart(final ContextStartedEvent cse) {
        // Print a message to the console when the context started event is handled
        System.out.println("Handling context started event.");
        // Set the flag to true indicating this handler was hit
        hitContextStartedHandler = true;
    }

    // Event listener for a successful GenericSpringEvent, condition checks if the event was
    // successful
    @EventListener(condition = "#event.success")
    public void handleSuccessful(final GenericSpringEvent<String> event) {
        // Print a message to the console when a successful generic event is handled
        System.out.println("Handling generic event (conditional): " + event.getWhat());
        // Set the flag to true indicating this handler was hit
        hitSuccessfulEventHandler = true;
    }

    // Transactional event listener for a CustomSpringEvent, set to trigger before commit of the
    // current transaction
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT) public void handleCustom(
            final CustomSpringEvent event) {
        // Print a message to the console when a custom event is handled inside a transaction
        // before commit
        System.out.println("Handling event inside a transaction BEFORE COMMIT.");
        // Set the flag to true indicating this handler was hit
        hitCustomEventHandler = true;
    }

    // Getter methods for the flags
    boolean isHitContextStartedHandler() {
        return hitContextStartedHandler;
    }

    boolean isHitSuccessfulEventHandler() {
        return hitSuccessfulEventHandler;
    }

    boolean isHitCustomEventHandler() {
        return hitCustomEventHandler;
    }
}
