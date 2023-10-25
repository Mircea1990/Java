package com.example.beanpostprocessor;

import java.util.Date;

// Use Lombok's @Getter annotation to automatically generate getter methods for all fields
@lombok.Getter public class StockTrade {
    // The stock symbol
    private final String symbol;
    // The quantity of stocks traded
    private final int quantity;
    // The price at which the stocks were traded
    private final double price;
    // The date of the trade
    private final Date tradeDate;

    // Constructor to initialize all fields of the StockTrade
    public StockTrade(String symbol, int quantity, double price, Date tradeDate) {
        this.symbol = symbol; // Initialize the stock symbol
        this.quantity = quantity; // Initialize the quantity of stocks traded
        this.price = price; // Initialize the price at which the stocks were traded
        this.tradeDate = tradeDate; // Initialize the date of the trade
    }
}

