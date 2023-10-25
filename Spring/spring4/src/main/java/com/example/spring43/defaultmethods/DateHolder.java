package com.example.spring43.defaultmethods;

import java.time.LocalDate;

// This is a public class named DateHolder which implements the IDateHolder interface.
public class DateHolder implements IDateHolder {
    // A private instance variable named localDate of type LocalDate.
    // This variable is used to hold the date value.
    private LocalDate localDate;

    // This is a public method that overrides the getLocalDate method from the IDateHolder
    // interface.
    // It returns the value of the localDate instance variable.
    @Override public LocalDate getLocalDate() {
        return localDate;
    }

    // This is a public method that overrides the setLocalDate method from the IDateHolder
    // interface.
    // It takes a LocalDate object as a parameter and assigns it to the localDate instance variable.
    @Override public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}

