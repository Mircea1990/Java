package com.example.component.autoproxying;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryLogAppender extends ListAppender<ILoggingEvent> {
    // Method to clear the list of logging events
    public void reset() {
        this.list.clear();
    }

    // Method to check if a specific message at a specific level exists in the list
    public boolean contains(String string, Level level) {
        return this.list.stream()
                .anyMatch(event -> event.getMessage().toString().contains(string)
                        && event.getLevel().equals(level));
    }

    // Method to count the number of events for a specific logger
    public int countEventsForLogger(String loggerName) {
        return (int) this.list.stream()
                .filter(event -> event.getLoggerName().contains(loggerName))
                .count();
    }

    // Method to search for a specific message in the list
    public List<ILoggingEvent> search(String string) {
        return this.list.stream()
                .filter(event -> event.getMessage().toString().contains(string))
                .collect(Collectors.toList());
    }

    // Method to search for a specific message at a specific level in the list
    public List<ILoggingEvent> search(String string, Level level) {
        return this.list.stream()
                .filter(event -> event.getMessage().toString().contains(string)
                        && event.getLevel().equals(level))
                .collect(Collectors.toList());
    }

    // Method to get the size of the list
    public int getSize() {
        return this.list.size();
    }

    // Method to get all logged events as an unmodifiable list
    public List<ILoggingEvent> getLoggedEvents() {
        return Collections.unmodifiableList(this.list);
    }
}
