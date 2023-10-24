package com.example.spring.patterns.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// The Application class
public class Application {
    // The main method of the Application class
    @SuppressWarnings("resource") public static void main(String[] args) {
        // Creates an ApplicationContext that accepts annotated classes as input - in this case,
        // ApplicationConfig.class
        ApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfig.class);
        // Gets the bean of type Foo from the application context
        Foo foo = context.getBean(Foo.class);
        // Gets the bean of type Bar from the application context and assigns a name to it
        Bar bar = context.getBean(Bar.class, "Some name");
        // Prints the foo object to the console
        System.out.println(foo);
        // Prints the name of the bar object to the console
        System.out.println("Bar's name: " + bar.getName());
    }
}

