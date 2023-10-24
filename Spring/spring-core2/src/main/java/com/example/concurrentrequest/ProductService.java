package com.example.concurrentrequest;

import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

// The @Service annotation is used in service layer and annotates classes that perform service tasks
@Service
public class ProductService {
    // @formatter:off is a special comment to turn off formatting by the IDE
    // A static list of products acting as a repository
    private final static List<Product> productRepository = asList(
            new Product(1, "Product 1", new Stock(100)),
            new Product(2, "Product 2", new Stock(50))
    );
    // @formatter:on is a special comment to turn the formatting back on

    // Method to get a product by its id from the repository
    public Optional<Product> getProductById(int id) {
        // Using Java 8 streams to filter and find the product with the given id
        Optional<Product> product = productRepository.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        // If the product is found, get its name. If not, return null.
        String productName = product.map(Product::getName)
                .orElse(null);
        // Print out the thread details, bean instance, product id and name
        System.out.printf("Thread: %s; bean instance: %s; product id: %s has the name: %s%n", currentThread().getName(),
                this, id, productName);
        // Return the found product (or null if not found)
        return product;
    }
}
