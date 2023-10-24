package com.example.beanfactory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.junit.Assert.assertTrue;

public class BeanFactoryWithClassPathResourceIntegrationTest {
    @Test
    // This is a test method to create a BeanFactory and check the Employee bean.
    public void createBeanFactoryAndCheckEmployeeBean() {
        // Create a Resource object by loading the XML configuration file from the classpath.
        Resource res = new ClassPathResource("beanfactory-example.xml");
        // Create a BeanFactory using the ClassPathXmlApplicationContext with the resource.
        BeanFactory factory = new ClassPathXmlApplicationContext(String.valueOf(res));
        // Get the Employee bean from the factory.
        Employee emp = (Employee) factory.getBean("employee");
        // Check if the 'employee' bean is a singleton in the factory.
        assertTrue(factory.isSingleton("employee"));
        // Check if the 'employee' bean is an instance of Employee class.
        assertTrue(factory.getBean("employee") instanceof Employee);
        // Check if the type of 'employee' bean matches with Employee.class.
        assertTrue(factory.isTypeMatch("employee", Employee.class));
        // Check if there are any aliases defined for 'employee' bean in the factory.
        assertTrue(factory.getAliases("employee").length > 0);
    }
}

