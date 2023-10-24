package com.springcore.applicationcontext;

import lombok.Getter;

import java.util.Locale;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
@Getter public class Dialog {
    // Represents the locale for this dialog
    private Locale locale;
    // Represents a hello message for this dialog
    private String hello;
    // Represents a thank you message for this dialog
    private String thanks;

    // Constructor to initialize a new Dialog with locale, hello message, and thank you message
    public Dialog(Locale locale, String hello, String thanks) {
        this.locale = locale;
        this.hello = hello;
        this.thanks = thanks;
    }

    // Setter method to update the locale of this dialog
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    // Setter method to update the hello message of this dialog
    public void setHello(String hello) {
        this.hello = hello;
    }

    // Setter method to update the thank you message of this dialog
    public void setThanks(String thanks) {
        this.thanks = thanks;
    }
}
