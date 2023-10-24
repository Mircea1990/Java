package com.example.concurrentrequest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test need to pause the main thread for up to 60 seconds
 */
// This annotation tells Spring Boot to look for a main configuration class and use that to start
// a Spring application context
@SpringBootTest
// This annotation auto-configures MockMvc
@AutoConfigureMockMvc public class ConcurrentRequestManualTest {
    // MockMvc instance is autowired
    @Autowired private MockMvc mockMvc;
    // ProductController instance is autowired
    @Autowired private ProductController controller;

    // This test method checks if the ProductController is available in the Spring context
    @Test public void givenContextLoads_thenProductControllerIsAvailable() {
        assertThat(controller).isNotNull();
    }

    // This test method checks if multiple calls run in parallel return 200 status code
    @Test public void givenMultipleCallsRunInParallel_thenAllCallsReturn200() throws Exception {
        // ExecutorService with a fixed thread pool is created
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Two tasks are submitted to the executor service to perform calls and check if the
        // status is OK (200)
        executor.submit(() -> performCall("/product/1", status().isOk()));
        executor.submit(() -> performCall("/product/2/stock", status().isOk()));
        // The executor service is terminated after 60 seconds if not done executing all tasks
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }

    // This method performs a GET request to the provided URL and expects the provided ResultMatcher
    private void performCall(String url, ResultMatcher expect) {
        try {
            this.mockMvc.perform(get(url)).andExpect(expect);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

