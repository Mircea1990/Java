package com.example.spring43.composedmapping;

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

import static org.easymock.EasyMock.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// The @ContextConfiguration annotation is used to specify the application context for the test.
// Here, it's loading the ComposedMappingConfiguration class.
// The @WebAppConfiguration is a class-level annotation that is used to declare that the
// ApplicationContext loaded for an integration test should be a WebApplicationContext.
@ContextConfiguration(classes = ComposedMappingConfiguration.class) @WebAppConfiguration
public class ComposedMappingIntegrationTest extends AbstractJUnit4SpringContextTests {

    // The @Autowired annotation is used for automatic dependency injection.
    // Here, it's injecting an instance of AppointmentService into the test.
    @Autowired private AppointmentService appointmentService;

    // MockMvc is a main entry point for server-side Spring MVC test support.
    private MockMvc mockMvc;

    // The WebApplicationContext is an extension of the plain ApplicationContext that has some
    // extra features necessary for web applications.
    // It differs from a normal ApplicationContext in that it is capable of resolving themes and
    // in that it knows which servlet it is associated with.
    @Autowired private WebApplicationContext wac;

    // The @Before annotation indicates that this method should be run before each test in this
    // class.
    // Here, it's setting up MockMvc to use the WebApplicationContext.
    @Before public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    // The @Test annotation indicates that this method is a test method.
    // This test checks if a GET request to "/appointments" returns a status of 200 (OK).
    @Test public void whenRequestingMethodWithGetMapping_thenReceiving200Answer() throws Exception {
        this.mockMvc.perform(get("/appointments").accept(MediaType.ALL)).andExpect(status().isOk());
        verify(appointmentService);
    }
}

