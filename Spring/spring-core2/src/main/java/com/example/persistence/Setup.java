package com.example.persistence;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

// The @Component annotation is used to indicate that a class is a "component".
// These classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
public class Setup implements ApplicationListener<ContextRefreshedEvent> {
    // A flag to check if the setup is done
    private boolean setupDone;

    // Default constructor
    public Setup() {
        super();
    }

    // This method is invoked when an ApplicationContext gets initialized or refreshed.
    // @NonNull ensures that the event object is not null.
    @Override
    public final void onApplicationEvent(@NonNull final ContextRefreshedEvent event) {
        // Check if the setup is not done
        if (!setupDone) {
            // Print a new line to the console
            System.out.println();
            // Mark the setup as done
            setupDone = true;
        }
    }
}

