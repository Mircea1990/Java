package com.example.ioccontainer;

import com.example.ioccontainer.bean.CustomBeanFactoryPostProcessor;
import com.example.ioccontainer.bean.CustomBeanPostProcessor;
import com.example.ioccontainer.bean.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOCContainerAppUnitTest {
    // This method resets the instantiation flags before and after each test.
    @BeforeEach @AfterEach public void resetInstantiationFlag() {
        Student.setBeanInstantiated(false);
        CustomBeanPostProcessor.setBeanPostProcessorRegistered(false);
        CustomBeanFactoryPostProcessor.setBeanFactoryPostProcessorRegistered(false);
    }

    // This test checks if a Student bean is not instantiated when a BeanFactory is initialized.
    @Test public void whenBFInitialized_thenStudentNotInitialized() {
        Resource res = new ClassPathResource("ioc-container-difference-example.xml");
        BeanFactory factory = new ClassPathXmlApplicationContext(String.valueOf(res));
        assertFalse(Student.isBeanInstantiated());
    }

    // This test checks if a Student bean is instantiated when a BeanFactory is initialized and a
    // getBean call is made.
    @Test public void whenBFInitialized_thenStudentInitialized() {
        Resource res = new ClassPathResource("ioc-container-difference-example.xml");
        BeanFactory factory = new ClassPathXmlApplicationContext(String.valueOf(res));
        Student student = (Student) factory.getBean("student");
        assertTrue(Student.isBeanInstantiated());
    }

    // This test checks if a Student bean is instantiated when an ApplicationContext is initialized.
    @Test public void whenAppContInitialized_thenStudentInitialized() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "ioc-container-difference-example.xml");
        assertTrue(Student.isBeanInstantiated());
    }

    // This test checks if BeanFactoryPostProcessor and BeanPostProcessor are not registered
    // automatically when a BeanFactory is initialized.
    @Test public void whenBFInitialized_thenBFPProcessorAndBPProcessorNotRegAutomatically() {
        Resource res = new ClassPathResource("ioc-container-difference-example.xml");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                String.valueOf(res));
        ConfigurableListableBeanFactory factory = context.getBeanFactory();
        assertFalse(CustomBeanFactoryPostProcessor.isBeanFactoryPostProcessorRegistered());
        assertFalse(CustomBeanPostProcessor.isBeanPostProcessorRegistered());
    }

    // This test checks if BeanFactoryPostProcessor and BeanPostProcessor can be registered
    // manually.
    @Test public void whenBFPostProcessorAndBPProcessorRegisteredManually_thenReturnTrue() {
        Resource res = new ClassPathResource("ioc-container-difference-example.xml");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                String.valueOf(res));
        ConfigurableListableBeanFactory factory = context.getBeanFactory();
        CustomBeanFactoryPostProcessor beanFactoryPostProcessor =
                new CustomBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(factory);
        assertTrue(CustomBeanFactoryPostProcessor.isBeanFactoryPostProcessorRegistered());
        CustomBeanPostProcessor beanPostProcessor = new CustomBeanPostProcessor();
        factory.addBeanPostProcessor(beanPostProcessor);
        Student student = (Student) factory.getBean("student");
        assertTrue(CustomBeanPostProcessor.isBeanPostProcessorRegistered());
    }

    // This test checks if BeanFactoryPostProcessor and BeanPostProcessor are registered
    // automatically when an ApplicationContext is initialized.
    @Test
    public void whenAppContInitialized_thenBFPostProcessorAndBPostProcessorRegisteredAutomatically() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "ioc-container-difference-example.xml");
        assertTrue(CustomBeanFactoryPostProcessor.isBeanFactoryPostProcessorRegistered());
        assertTrue(CustomBeanPostProcessor.isBeanPostProcessorRegistered());
    }
}

