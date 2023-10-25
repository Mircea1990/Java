package com.example.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

// Annotating this class as a Spring Component with the name "myHealthCheck"
@Component("myHealthCheck") public class HealthCheck implements HealthIndicator {

    // This method checks the health of the application
    @Override public Health health() {
        // Checking for errors in the application
        int errorCode = check();

        // If there is an error (errorCode != 0), return the status as DOWN
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }

        // If there are no errors, return the status as UP
        return Health.up().build();
    }

    // This method checks for errors in the application and returns an error code
    public int check() {
        // In this case, it always returns 0 (no error)
        return 0;
    }
}
