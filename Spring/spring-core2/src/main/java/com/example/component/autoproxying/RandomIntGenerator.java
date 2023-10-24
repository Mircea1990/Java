package com.example.component.autoproxying;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

// The @Slf4j annotation is used to enable the Simple Logging Facade for Java (SLF4J) which simplifies logging in Java applications.
@Slf4j
// The @Component annotation indicates that an annotated class is a "component".
// Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
public class RandomIntGenerator {
    // A private final instance of the Random class.
    private final Random random = new Random();

    // The constructor for this class. It takes a DataCache as a parameter.
    public RandomIntGenerator(DataCache dataCache) {
    }

    // This method generates a random integer between the given min and max values.
    public int generate(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}

