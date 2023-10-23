package com.springcore.applicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Course course = new Course("Matematică");
        System.out.println("Numele cursului: " + course.getName());
        Dialog dialog = new Dialog(Locale.getDefault(), "Bună", "Mulțumesc");
        System.out.println("Dialog în " + dialog.getLocale().getDisplayLanguage() + ": " + dialog.getHello() + ", " +
                dialog.getThanks());
        Student student = new Student(1, "Ion");
        System.out.println("Student: no=" + student.getNo() + ", name=" + student.getName());
        Teacher teacher = context.getBean(Teacher.class);
        System.out.println("Profesorul are " + teacher.getCourses().size() + " cursuri.");
       
    }
}

