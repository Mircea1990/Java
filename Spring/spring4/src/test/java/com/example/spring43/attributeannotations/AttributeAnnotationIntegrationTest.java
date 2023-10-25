package com.example.spring43.attributeannotations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// The @ContextConfiguration annotation is used to specify the application context for the test.
// It loads the configuration from the AttributeAnnotationConfiguration class.
// The @WebAppConfiguration annotation is used to declare that the ApplicationContext loaded for
// an integration test should be a WebApplicationContext.
@ContextConfiguration(classes = AttributeAnnotationConfiguration.class) @WebAppConfiguration
public class AttributeAnnotationIntegrationTest extends AbstractJUnit4SpringContextTests {
    // MockMvc is a main entry point for server-side Spring MVC test support.
    private MockMvc mockMvc;
    // The @Autowired annotation is used to auto-wire spring bean on setter methods, instance
    // variable, and constructor.
    // Here it's injecting an instance of WebApplicationContext into this test class.
    @Autowired private WebApplicationContext wac;

    // The @Before annotation indicates that this method must be executed before each test in the
    // class, so as to set up some test conditions.
    // Here it's setting up MockMvc to use the web application context.
    @Before public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    // The @Test annotation tells JUnit that the public void method to which it is attached can
    // be run as a test case.
    // This test case is checking if the interceptor adds request and session parameters correctly.
    @Test
    public void whenInterceptorAddsRequestAndSessionParams_thenParamsInjectedWithAttributesAnnotations()
            throws Exception {
        String result = this.mockMvc.perform(get("/test").accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();
        // Assert class is used for writing test cases, assertEquals checks if the two objects
        // are equal.
        Assert.assertEquals("login = john, query = invoices", result);
    }
}

