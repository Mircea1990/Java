package com.example.spring43.scopeannotations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @ContextConfiguration is a Spring annotation used to specify the application context
// configuration to load for an integration test.
// Here, it's loading the configuration from the ScopeAnnotationsConfiguration class.
@ContextConfiguration(classes = ScopeAnnotationsConfiguration.class)

// @WebAppConfiguration is a Spring annotation that declares that the ApplicationContext loaded
// for an integration test should be a WebApplicationContext.
@WebAppConfiguration

public class ScopeAnnotationsIntegrationTest extends AbstractJUnit4SpringContextTests {
    // MockMvc is a Spring class used to test MVC controllers without running a full HTTP server.
    private MockMvc mockMvc;

    // @Autowired is used to automatically wire the WebApplicationContext into this class,
    // allowing you to use it to access the methods of WebApplicationContext.
    @Autowired private WebApplicationContext wac;

    // @Before is a JUnit annotation that indicates that the annotated method will be run before
    // each test in the class.
    @Before public void setup() {
        // MockMvcBuilders.webAppContextSetup(wac).build() creates a MockMvc instance using the
        // provided WebApplicationContext.
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    // @Test is a JUnit annotation indicating that the public void method to which it is attached
    // can be run as a test case.
    @Test public void whenDifferentRequests_thenDifferentInstancesOfRequestScopedBeans()
            throws Exception {
        // MockHttpSession is a mock implementation of HttpSession. Here, it's creating a new
        // session.
        MockHttpSession session = new MockHttpSession();

        // mockMvc.perform(get("/appointments/request").session(session).accept(MediaType.ALL))
        // sends a GET request to "/appointments/request" with the specified session and
        // MediaType.ALL as accepted response media types.
        // andExpect(status().isOk()) checks if the response status is OK (200).
        // andReturn().getResponse().getContentAsString() gets the response content as a string.
        String requestScopedServiceInstanceNumber1 = this.mockMvc.perform(get(
                "/appointments/request").session(session).accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();

        // The same process is repeated, and it's expected that different instances of
        // request-scoped beans are created for different requests, even within the same session.
        String requestScopedServiceInstanceNumber2 = this.mockMvc.perform(get(
                "/appointments/request").session(session).accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();

        // assertNotEquals checks that two objects do not refer to the equal objects. If they do,
        // the test fails.
        assertNotEquals(requestScopedServiceInstanceNumber1, requestScopedServiceInstanceNumber2);
    }

    // This test checks if different instances of session-scoped beans are created for different
    // sessions.
    @Test public void whenDifferentSessions_thenDifferentInstancesOfSessionScopedBeans()
            throws Exception {
        // Two different sessions are created here.
        MockHttpSession session1 = new MockHttpSession();
        MockHttpSession session2 = new MockHttpSession();

        // A GET request is sent twice within the same session (session1), and it's expected that
        // the same instance of session-scoped beans is returned.
        String sessionScopedServiceInstanceNumber1 = this.mockMvc.perform(get(
                "/appointments/session").session(session1).accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();
        String sessionScopedServiceInstanceNumber2 = this.mockMvc.perform(get(
                "/appointments/session").session(session1).accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();

        // A GET request is sent within a different session (session2), and it's expected that a
        // different instance of session-scoped beans is returned.
        String sessionScopedServiceInstanceNumber3 = this.mockMvc.perform(get(
                "/appointments/session").session(session2).accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();

        // assertEquals checks that two objects refer to the equal objects. If they do not, the
        // test fails.
        assertEquals(sessionScopedServiceInstanceNumber1, sessionScopedServiceInstanceNumber2);

        // assertNotEquals checks that two objects do not refer to the equal objects. If they do,
        // the test fails.
        assertNotEquals(sessionScopedServiceInstanceNumber1, sessionScopedServiceInstanceNumber3);
    }

    // This test checks if always single instance of application-scoped bean is returned for
    // different sessions and requests.
    @Test public void whenDifferentSessionsAndRequests_thenAlwaysSingleApplicationScopedBean()
            throws Exception {
        // Two different sessions are created here.
        MockHttpSession session1 = new MockHttpSession();
        MockHttpSession session2 = new MockHttpSession();

        // A GET request is sent within two different sessions, and it's expected that the same
        // instance of application-scoped beans is returned in both cases.
        String applicationScopedServiceInstanceNumber1 = this.mockMvc.perform(get(
                "/appointments/application").session(session1).accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();
        String applicationScopedServiceInstanceNumber2 = this.mockMvc.perform(get(
                "/appointments/application").session(session2).accept(MediaType.ALL)).andExpect(
                status().isOk()).andReturn().getResponse().getContentAsString();

        // assertEquals checks that two objects refer to the equal objects. If they do not, the
        // test fails.
        assertEquals(applicationScopedServiceInstanceNumber1,
                     applicationScopedServiceInstanceNumber2);
    }
}

