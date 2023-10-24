package com.example.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// This annotation tells JUnit to run the test using Spring's testing support.
// SpringJUnit4ClassRunner is a custom extension of JUnit's BlockJUnit4ClassRunner which provides
// functionality of the Spring TestContext Framework to standard JUnit tests.
@RunWith(SpringJUnit4ClassRunner.class)
// This annotation is used to specify the configuration classes to load for this test class.
@ContextConfiguration(classes = FactoryBeanAppConfig.class)
public class FactoryBeanJavaConfigIntegrationTest {
    // The @Autowired annotation is used to automatically wire the 'tool' bean.
    @Autowired private Tool tool;
    // The @Resource annotation is used to automatically wire the 'toolFactory' bean. The '&'
    // prefix is used to get a reference to the factory bean itself, instead of the bean it
    // produces.
    @Resource(name = "&tool") private ToolFactory toolFactory;

    @Test
    // This test method checks if the 'tool' and 'toolFactory' beans are correctly constructed by
    // Java configuration.
    public void testConstructWorkerByJava() {
        // Assert that the ID of 'tool' is 2.
        assertThat(tool.getId(), equalTo(2));
        // Assert that the factory ID of 'toolFactory' is 7070.
        assertThat(toolFactory.getFactoryId(), equalTo(7070));
    }
}
