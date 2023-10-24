package com.springcore.applicationcontext;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

// The @Component annotation indicates that an annotated class is a "component".
// Such classes are considered as candidates for auto-detection when using annotation-based
// configuration and classpath scanning.
@Component public class Teacher {
    // The @Autowired annotation provides control over where and how autowiring should be
    // accomplished.
    // The @Autowired annotation can be used to autowire bean on the setter method, constructor,
    // a property or methods with arbitrary names and/or multiple arguments.
    // Here it is used to autowire the ApplicationContext, which is an interface representing the
    // Spring IoC container.
    @Autowired private ApplicationContext context;
    // The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
    @Getter
    // Represents the list of courses that this teacher teaches
    private List<Course> courses = new ArrayList<>();

    // Default constructor for the Teacher class
    public Teacher() {
    }

    // The @PostConstruct annotation is used on a method that needs to be executed after
    // dependency injection is done to perform any initialization.
    // This method MUST be invoked before the class is put into service.
    // This annotation MUST be supported on all classes that support dependency injection.
    // The method annotated with PostConstruct MUST be invoked even if the class does not request
    // any resources to be injected.
    @PostConstruct public void addCourse() {
        // Adding two instances of the "math" course if it exists in the context
        for (int i = 0; i < 2; i++) {
            if (context.containsBean("math")) {
                Course math = context.getBean("math", Course.class);
                courses.add(math);
            }
        }
        // Adding three instances of the "physics" course if it exists in the context
        for (int i = 0; i < 3; i++) {
            if (context.containsBean("physics")) {
                Course physics = context.getBean("physics", Course.class);
                courses.add(physics);
            }
        }
    }

    // Setter method to update the list of courses this teacher teaches
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}


