package com.example.concurrentrequest;

import lombok.Getter;

// The @Getter annotation is a Lombok annotation to auto-generate getters for all fields.
@Getter public class Product {
    // Unique identifier for a product
    private final int id;
    // Name of the product
    private final String name;
    // Stock details of the product
    private final Stock stock;

    // Constructor to initialize a product with its id, name, and stock details
    public Product(int id, String name, Stock stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }
}

