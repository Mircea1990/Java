package com.example.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// This annotation tells JUnit to run the test with Spring's testing support.
// SpringJUnit4ClassRunner is a custom extension of JUnit's BlockJUnit4ClassRunner which provides
// functionality of the Spring TestContext Framework to standard JUnit tests.
@RunWith(SpringJUnit4ClassRunner.class)

// This annotation is used to specify the locations of configuration files that are loaded for
// your test. Here, it's loading an XML configuration file from the classpath.
@ContextConfiguration(locations = {"classpath:factorybean-spring-ctx.xml"})

// This is the test class for testing the integration of FactoryBean with XML configuration.
public class FactoryBeanXmlConfigIntegrationTest {

    // @Autowired is used for automatic dependency injection. Here, it's injecting an instance of
    // Tool.
    @Autowired private Tool tool;

    // @Resource is similar to @Autowired, but it also provides a 'name' attribute which can be
    // used for more precise autowiring by name. Here, it's injecting a factory of Tool named
    // 'tool'.
    @Resource(name = "&tool") private ToolFactory toolFactory;

    // This is a test case where we're testing the construction of a worker by XML configuration.
    @Test public void testConstructWorkerByXml() {
        // Asserting that the ID of the tool is 1.
        assertThat(tool.getId(), equalTo(1));
        // Asserting that the factory ID of the tool factory is 9090.
        assertThat(toolFactory.getFactoryId(), equalTo(9090));
    }
}
