package com.springcore.annotation;

import org.springframework.stereotype.Component;

// The @Component annotation is used to mark a class as a Spring Component.
// It means that Spring framework will autodetect this class for dependency injection when annotation-based configuration and classpath scanning is used.
@Component
public class TestBean {
}