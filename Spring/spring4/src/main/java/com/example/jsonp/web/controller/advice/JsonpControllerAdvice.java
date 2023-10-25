package com.example.jsonp.web.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

// The @SuppressWarnings annotation is used to suppress compiler warnings for the annotated element.
// Here it's suppressing deprecation warnings. This is typically used when a deprecated class or
// method is unavoidable.
@SuppressWarnings("deprecation")

// The @ControllerAdvice annotation is a specialization of the @Component annotation which allows
// to handle exceptions across the whole application in one global handling component.
// It can be viewed as an interceptor of exceptions thrown by methods annotated with
// @RequestMapping and similar.
@ControllerAdvice

// The class 'JsonpControllerAdvice' extends 'AbstractJsonpResponseBodyAdvice' which is a Spring
// class that adds support for JSONP as a return type from a Spring MVC Controller method.
public class JsonpControllerAdvice extends AbstractJsonpResponseBodyAdvice {

    // The constructor for 'JsonpControllerAdvice'. It calls the superclass constructor with
    // "callback" as an argument.
    // This means that it's looking for a query parameter named "callback" to use for JSONP.
    public JsonpControllerAdvice() {
        super("callback");
    }
}

