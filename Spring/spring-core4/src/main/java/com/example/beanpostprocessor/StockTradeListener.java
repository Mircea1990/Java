package com.example.beanpostprocessor;

// Declare a functional interface. A functional interface is an interface that contains only one
// abstract method.
@FunctionalInterface public interface StockTradeListener {
    // Abstract method to be implemented by any class that implements this interface.
    // This method will be called when a stock trade is published.
    void stockTradePublished(StockTrade trade);
}

