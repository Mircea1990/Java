package com.springcore.springbean.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

// The @Data annotation is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields
@Data
// The @Component annotation is used in Spring Framework to denote a class as Component. It means that Spring will auto-detect these classes for dependency injection when annotation-based configuration and classpath scanning is used.
@Component
public class Company {
    // A private variable of type Address to hold the company's address
    private Address address;

    // This is a constructor for the Company class that initializes the company's address
    public Company(Address address) {
        this.address = address;
    }
}

