package com.springcore.methodinjections;

import java.util.Collection;

import org.springframework.stereotype.Component;

// The @Component annotation is used to indicate that the class is a "component". These classes are considered
// as candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
public class Grader {
    // This is a method that grades a collection of marks.
    public String grade(Collection<Integer> marks) {
        // Here we're using Java 8's Stream API to process the collection. The anyMatch() operation here is
        // a short-circuiting terminal operation, which means it doesn't need to process the whole stream to
        // return a result. It returns true if any elements of this stream match the provided predicate.
        boolean result = marks.stream()
                .anyMatch(mark -> mark < 45);  // The predicate here checks if a mark is less than 45.
        // If any mark is less than 45, the method returns "FAIL".
        if (result) {
            return "FAIL";
        }
        // If all marks are 45 or above, the method returns "PASS".
        return "PASS";
    }
}

