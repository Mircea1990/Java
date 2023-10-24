package com.springcore.setterdi;

import com.springcore.setterdi.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// This is a public class named SpringRunner
public class SpringRunner {
    // The main method which is the entry point of the program
    public static void main(String[] args) {
        // Getting a Car object from an XML configuration
        Car toyota = getCarFromXml();
        // Printing the details of the car
        System.out.println(toyota);
        // Getting a Car object from a Java configuration
        toyota = getCarFromJavaConfig();
        // Printing the details of the car
        System.out.println(toyota);
    }

    // A private static method that returns a Car object configured using Java configuration
    private static Car getCarFromJavaConfig() {
        // Creating an ApplicationContext object using AnnotationConfigApplicationContext and SetterDIConfig class
        ApplicationContext context = new AnnotationConfigApplicationContext(SetterDIConfig.class);
        // Getting a Car bean from the context and returning it
        return context.getBean(Car.class);
    }

    // A private static method that returns a Car object configured using XML configuration
    private static Car getCarFromXml() {
        // Creating an ApplicationContext object using ClassPathXmlApplicationContext and an XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("setterdi.xml");
        // Getting a Car bean from the context and returning it
        return context.getBean(Car.class);
    }
}
