package com.example.flips.service;

import com.example.flips.model.Foo;
import org.springframework.stereotype.Service;

// The @Service annotation is used with classes that provide some business functionalities.
@Service public class NewFlipService {
    // This method returns a new Foo object with the name "Shiny New Foo!" and id 100.
    public Foo getNewFoo() {
        return new Foo("Shiny New Foo!", 100);
    }
}
