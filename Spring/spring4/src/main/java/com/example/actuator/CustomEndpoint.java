package com.example.actuator;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Annotating this class as a Spring Component
@Component public class CustomEndpoint implements Endpoint<List<String>> {

    // This method returns the ID of the endpoint
    @Override public String getId() {
        return "customEndpoint";
    }

    // This method checks if the endpoint is enabled or not
    @Override public boolean isEnabled() {
        return true;
    }

    // This method checks if the endpoint is sensitive or not
    @Override public boolean isSensitive() {
        return true;
    }

    // This method is invoked when a request is made to this endpoint
    @Override public List<String> invoke() {
        List<String> messages = new ArrayList<>();
        messages.add("This is message 1");
        messages.add("This is message 2");
        return messages;
    }
}