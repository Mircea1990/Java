package com.springcore.methodinjections;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

// The @Component annotation is used to indicate that the class is a "component".
// These classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
// The string "studentService" is the specific name of the bean to be created, instead of the default one.
@Component("studentService")
// This is an abstract class named StudentServices. It can't be instantiated, but it can be subclassed.
public abstract class StudentServices {
    // This is a private map that stores SchoolNotification instances associated with student names.
    private Map<String, SchoolNotification> notes = new HashMap<>();

    // The @Lookup annotation is used on an abstract method to override and dynamically return a prototype bean from the Spring Container.
    // Here it's used to get a new instance of SchoolNotification every time it's needed.
    @Lookup
    protected abstract SchoolNotification getNotification(String name);

    // This method appends a mark to a student's SchoolNotification. If the student doesn't have a SchoolNotification yet,
    // it creates one using the getNotification method.
    public String appendMark(String name, Integer mark) {
        // The computeIfAbsent method checks if there's already a SchoolNotification for the student.
        // If not, it creates one using the provided function (getNotification).
        SchoolNotification notification = notes.computeIfAbsent(name, exists -> getNotification(name));
        // It then adds the mark to the SchoolNotification and returns the result of grading.
        return notification.addMark(mark);
    }
}

