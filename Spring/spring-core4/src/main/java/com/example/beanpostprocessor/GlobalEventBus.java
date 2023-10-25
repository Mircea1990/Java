package com.example.beanpostprocessor;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

//@SuppressWarnings("ALL")
public final class GlobalEventBus {
    // Expression to get the global event bus instance
    public static final String GLOBAL_EVENT_BUS_EXPRESSION =
            "T(com.example.beanpostprocessor.GlobalEventBus).getEventBus()";

    // Identifier for the global event bus
    private static final String IDENTIFIER = "global-event-bus";

    // Singleton instance of the global event bus
    private static final GlobalEventBus GLOBAL_EVENT_BUS = new GlobalEventBus();

    // Event bus instance, initialized with an asynchronous executor
    private final EventBus eventBus = new AsyncEventBus(IDENTIFIER,
                                                        Executors.newCachedThreadPool());

    // Private constructor to prevent instantiation
    private GlobalEventBus() {
    }

    // Method to get the singleton instance of the global event bus
    public static GlobalEventBus getInstance() {
        return GlobalEventBus.GLOBAL_EVENT_BUS;
    }

    // Method to get the event bus instance
    public static EventBus getEventBus() {
        return GlobalEventBus.GLOBAL_EVENT_BUS.eventBus;
    }

    // Method to subscribe an object to the event bus
    public static void subscribe(Object obj) {
        getEventBus().register(obj);
    }

    // Method to unsubscribe an object from the event bus
    public static void unsubscribe(Object obj) {
        getEventBus().unregister(obj);
    }

    // Method to post an event to the event bus
    public static void post(Object event) {
        getEventBus().post(event);
    }
}
