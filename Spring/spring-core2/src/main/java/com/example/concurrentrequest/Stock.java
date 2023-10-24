package com.example.concurrentrequest;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate getters for all fields.
@Getter
public class Stock {
    // The number of items in stock
    private final int inStockItems;

    // Constructor to initialize a stock with its item count
    public Stock(int inStockItems) {
        this.inStockItems = inStockItems;
    }
}

