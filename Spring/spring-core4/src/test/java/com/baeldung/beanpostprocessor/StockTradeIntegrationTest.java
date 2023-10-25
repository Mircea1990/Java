package com.baeldung.beanpostprocessor;

import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import com.example.beanpostprocessor.*;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

// This annotation tells JUnit to run the test with SpringJUnit4ClassRunner which is a custom
// extension of JUnit's BlockJUnit4ClassRunner which provides functionality of the Spring
// TestContext Framework.
@RunWith(SpringJUnit4ClassRunner.class)
// This annotation is used to specify which configuration classes will be used to load the
// context for the test. Here, it's loading the PostProcessorConfiguration class.
@ContextConfiguration(classes = {PostProcessorConfiguration.class})
public class StockTradeIntegrationTest {
    // This annotation is used for automatic dependency injection. Here, it's injecting an
    // instance of StockTradePublisher.
    @Autowired private StockTradePublisher stockTradePublisher;

    // This annotation indicates that the public void method to which it is attached can be run
    // as a test case in JUnit.
    @Test public void givenValidConfig_whenTradePublished_thenTradeReceived() {
        // Creating a new Date object for tradeDate.
        Date tradeDate = new Date();
        // Creating a new StockTrade object with symbol "AMZN", quantity 100, price 2483.52, and
        // the current date.
        StockTrade stockTrade = new StockTrade("AMZN", 100, 2483.52d, tradeDate);
        // Creating an AtomicBoolean initialized to false. It will be set to true if the test
        // passes.
        AtomicBoolean assertionsPassed = new AtomicBoolean(false);
        // Creating a listener that sets assertionsPassed to the result of verifyExact method
        // when a trade is received.
        StockTradeListener listener = trade -> assertionsPassed.set(
                this.verifyExact(stockTrade, trade));
        // Adding the listener to the stockTradePublisher.
        this.stockTradePublisher.addStockTradeListener(listener);
        try {
            // Posting the stockTrade to the GlobalEventBus.
            GlobalEventBus.post(stockTrade);
            // Waiting up to 2 seconds for assertionsPassed to be true.
            await().atMost(Duration.ofSeconds(2L)).untilAsserted(
                    () -> assertThat(assertionsPassed.get()).isTrue());
        } finally {
            // Removing the listener from the stockTradePublisher.
            this.stockTradePublisher.removeStockTradeListener(listener);
        }
    }

    // This method checks if all fields of two StockTrade objects are equal and returns true if
    // they are and false otherwise.
    private boolean verifyExact(StockTrade stockTrade, StockTrade trade) {
        return Objects.equals(stockTrade.getSymbol(), trade.getSymbol()) && Objects.equals(
                stockTrade.getTradeDate(), trade.getTradeDate()) &&
               stockTrade.getQuantity() == trade.getQuantity() &&
               stockTrade.getPrice() == trade.getPrice();
    }
}
