package com.springcore.applicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

// @SpringBootApplication is a convenience annotation that adds all of the following:
// @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the 'com/example' package, letting it find the controllers.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // The SpringApplication.run() method returns a ConfigurableApplicationContext which we can use to get beans from our application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        // Create a new Course object with the name "Matematică"
        Course course = new Course("Matematică");
        // Print the name of the course
        System.out.println("Numele cursului: " + course.getName());
        // Create a new Dialog object with the default locale and greetings in Romanian
        Dialog dialog = new Dialog(Locale.getDefault(), "Bună", "Mulțumesc");
        // Print the dialog in the default language
        System.out.println("Dialog în " + dialog.getLocale().getDisplayLanguage() + ": " + dialog.getHello() + ", " +
                dialog.getThanks());
        // Create a new Student object with number 1 and name "Ion"
        Student student = new Student(1, "Ion");
        // Print the student's number and name
        System.out.println("Student: no=" + student.getNo() + ", name=" + student.getName());
        // Get a bean of type Teacher from the application context
        Teacher teacher = context.getBean(Teacher.class);
        // Print the number of courses that the teacher has
        System.out.println("Profesorul are " + teacher.getCourses().size() + " cursuri.");
    }
}


