package com.example.component.autoproxying;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// The @Retention annotation is used to indicate how long the annotation is to be retained.
// RetentionPolicy.RUNTIME means that this annotation will be available to the JVM through runtime.
@Retention(RetentionPolicy.RUNTIME)
// This is a custom annotation interface named RandomInt.
public @interface RandomInt {
    // An abstract method representing the minimum value for the RandomInt annotation.
    int min();

    // An abstract method representing the maximum value for the RandomInt annotation.
    int max();
}

