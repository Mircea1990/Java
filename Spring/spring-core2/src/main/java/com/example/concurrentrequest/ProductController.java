package com.example.concurrentrequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// The @RestController annotation is used to define a controller for RESTful web services.
@RestController()
// @RequestMapping is used to map web requests onto specific handler classes and/or handler methods.
@RequestMapping("product") public class ProductController {
    // An instance of ProductService to handle product-related operations
    private final ProductService productService;

    // Constructor to initialize ProductController with a ProductService
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method =
    // GET).
    // Method to get product details by product id
    @GetMapping("/{id}") public Product getProductDetails(@PathVariable("id") int productId) {
        // Fetch the product by id from the productService. If not found, return null.
        return productService.getProductById(productId).orElse(null);
    }

    // Method to get stock details of a product by product id
    @GetMapping("{id}/stock") public Stock getProductStock(@PathVariable("id") int productId) {
        // Fetch the product by id from the productService, get its stock details. If not found,
        // return null.
        return productService.getProductById(productId).map(Product::getStock).orElse(null);
    }
}

