package com.springcore.applicationcontext;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Teacher {
    @Autowired
    private ApplicationContext context;
    @Getter
    private List<Course> courses = new ArrayList<>();

    public Teacher() {
    }

    @PostConstruct
    public void addCourse() {
        for (int i = 0; i < 2; i++) {
            if (context.containsBean("math")) {
                Course math = context.getBean("math", Course.class);
                courses.add(math);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (context.containsBean("physics")) {
                Course physics = context.getBean("physics", Course.class);
                courses.add(physics);
            }
        }
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

