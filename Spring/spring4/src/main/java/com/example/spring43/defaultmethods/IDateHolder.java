package com.example.spring43.defaultmethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// This is a public interface named IDateHolder.
public interface IDateHolder {
    // This is an abstract method that returns a LocalDate object.
    // Classes implementing this interface must provide an implementation for this method.
    LocalDate getLocalDate();

    // This is an abstract method that takes a LocalDate object as a parameter.
    // Classes implementing this interface must provide an implementation for this method.
    void setLocalDate(LocalDate localDate);

    // This is a default method provided in the interface itself.
    // It takes a String object as a parameter, converts it to a LocalDate object using the
    // specified date format "dd.MM.yyyy",
    // and then calls the setLocalDate method with the converted LocalDate object.
    default void setStringDate(String stringDate) {
        setLocalDate(LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}

