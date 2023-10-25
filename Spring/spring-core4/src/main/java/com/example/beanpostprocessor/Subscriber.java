package com.example.beanpostprocessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation which indicates which Guava {@link com.google.common.eventbus.EventBus} a Spring
 * bean wishes to subscribe to.
 */
// @Retention annotation specifies that this annotation should be retained at runtime.
@Retention(RetentionPolicy.RUNTIME)
// @Target annotation specifies that this annotation can be applied to types (classes,
// interfaces, enums).
@Target(ElementType.TYPE)
// @Inherited annotation indicates that the annotation type can be inherited from the super class.
@Inherited public @interface Subscriber {
    /**
     * A SpEL expression which selects the {@link com.google.common.eventbus.EventBus}.
     */
    // The value method returns a SpEL (Spring Expression Language) expression that selects the
    // EventBus.
    // If no value is provided for this annotation, it defaults to the global event bus expression.
    String value() default GlobalEventBus.GLOBAL_EVENT_BUS_EXPRESSION;
}

