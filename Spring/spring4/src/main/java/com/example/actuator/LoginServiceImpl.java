package com.example.actuator;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

// Annotating this class as a Spring Service
@Service public class LoginServiceImpl {
    // CounterService instance for counting login attempts
    private final CounterService counterService;

    // Constructor for LoginServiceImpl, initializing CounterService
    public LoginServiceImpl(CounterService counterService) {
        this.counterService = counterService;
    }

    // Method to handle login attempts
    public boolean login(String userName, char[] password) {
        boolean success;
        // If the username is "admin" and password is "secret", login is successful
        if (userName.equals("admin") && Arrays.equals("secret".toCharArray(), password)) {
            // Increment the success counter
            counterService.increment("counter.login.success");
            success = true;
        } else {
            // If login details are incorrect, increment the failure counter
            counterService.increment("counter.login.failure");
            success = false;
        }
        // Return the result of the login attempt
        return success;
    }
}
