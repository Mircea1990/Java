package com.example.beanpostprocessor;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import java.util.HashSet;
import java.util.Set;

// The @Subscriber annotation indicates that this class is a subscriber in an event bus system.
public class StockTradePublisher {
    // A set of listeners for stock trade events.
    private final Set<StockTradeListener> stockTradeListeners = new HashSet<>();

    // Method to add a new listener to the set.
    public void addStockTradeListener(StockTradeListener listener) {
        // Synchronized block to prevent concurrent modification of the set.
        synchronized (this.stockTradeListeners) {
            this.stockTradeListeners.add(listener);
        }
    }

    // Method to remove a listener from the set.
    public void removeStockTradeListener(StockTradeListener listener) {
        // Synchronized block to prevent concurrent modification of the set.
        synchronized (this.stockTradeListeners) {
            this.stockTradeListeners.remove(listener);
        }
    }

    // This method is subscribed to StockTrade events. It will be invoked when a StockTrade event
    // is posted on the event bus.
    // The @AllowConcurrentEvents annotation indicates that multiple events can be handled
    // concurrently by this method.
    public void handleNewStockTradeEvent(StockTrade trade) {
        // You can add code here to publish the trade to a database, send it to PubNub, etc.

        final Set<StockTradeListener> listeners;
        // Synchronized block to prevent concurrent modification of the set while creating a copy
        // of it.
        synchronized (this.stockTradeListeners) {
            listeners = new HashSet<>(this.stockTradeListeners);
        }
        // Notify all listeners about the published trade.
        listeners.forEach(li -> li.stockTradePublished(trade));
    }
}

