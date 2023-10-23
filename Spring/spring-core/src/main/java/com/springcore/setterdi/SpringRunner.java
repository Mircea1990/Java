package com.springcore.setterdi;

import com.springcore.setterdi.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {
    public static void main(String[] args) {
        Car toyota = getCarFromXml();
        System.out.println(toyota);
        toyota = getCarFromJavaConfig();
        System.out.println(toyota);

    }

    private static Car getCarFromJavaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SetterDIConfig.class);
        return context.getBean(Car.class);
    }

    private static Car getCarFromXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("setterdi.xml");
        return context.getBean(Car.class);
    }
}