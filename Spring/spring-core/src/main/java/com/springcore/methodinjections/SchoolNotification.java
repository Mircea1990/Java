package com.springcore.methodinjections;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// The @Component annotation is used to indicate that the class is a "component".
// These classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
// The string "schoolNotification" is the specific name of the bean to be created, instead of the default one.
@Component("schoolNotification")
// The @Scope annotation is used to specify the scope of the beans created by Spring IoC container.
// Here it is set to ConfigurableBeanFactory.SCOPE_PROTOTYPE, which means a new instance will be created each time an injection is performed.
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SchoolNotification {
    // The @Autowired annotation is used to autowire spring bean on setter methods, instance variable, and constructor.
    // Here it's injecting an instance of Grader into this class.
    @Autowired
    Grader grader;
    // The @Getter annotation from Lombok library generates getters for these fields.
    @Getter private String name;
    @Getter private Collection<Integer> marks;

    // This is the constructor of the SchoolNotification class. It initializes the name with the provided value and creates a new ArrayList for marks.
    public SchoolNotification(String name) {
        this.name = name;
        this.marks = new ArrayList<Integer>();
    }

    // This method adds a mark to the collection and then uses the Grader instance to grade the updated collection.
    // It returns the result of grading.
    public String addMark(Integer mark) {
        this.marks.add(mark);
        return this.grader.grade(this.marks);
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for marks
    public void setMarks(Collection<Integer> marks) {
        this.marks = marks;
    }
}
