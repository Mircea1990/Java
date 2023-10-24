package com.springcore.event.listener;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// This annotation indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
public class ContextEventListener {
    // This method is an event listener method that gets triggered when the context is started. The @Order annotation indicates the order in which this method should be executed.
    @Order(2)
    @EventListener
    public void handleContextRefreshEvent(ContextStartedEvent ctxStartEvt) {
        System.out.println("Context Start Event received.");
    }

    // This method is an event listener method that gets triggered when multiple events occur. It listens for both ContextStartedEvent and ContextStoppedEvent. The @Order annotation indicates the order in which this method should be executed.
    @Order(1)
    @EventListener(classes = {ContextStartedEvent.class, ContextStoppedEvent.class})
    public void handleMultipleEvents() {
        System.out.println("Multi-event listener invoked");
    }
}

