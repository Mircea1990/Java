package com.springcore;

import com.springcore.streamutils.CopyStream;
import com.springcore.streamutils.DrainStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    // The main method is the entry point for the application.
    public static void main(String[] args) throws IOException {
        // An ApplicationContext is a Spring container that provides configuration for application.
        // This line creates a new ApplicationContext using the given package name.
        ApplicationContext context = new AnnotationConfigApplicationContext("com.springcore");
        // Get the CopyStream bean from the context.
        CopyStream copyStream = context.getBean(CopyStream.class);
        // Use the CopyStream bean to get content from an InputStream.
        String content = CopyStream.getStringFromInputStream(copyStream.getNonClosingInputStream());
        // Print the content obtained from the InputStream.
        System.out.println("Content from input stream: " + content);
        // Get the DrainStream bean from the context.
        DrainStream drainStream = context.getBean(DrainStream.class);
        // Use the DrainStream bean to get an InputStream.
        InputStream inputStream = drainStream.getInputStream();
        // Check if the InputStream is null and print the result.
        System.out.println("Input stream is null: " + (inputStream == null));
        // Get the LibraryUtils bean from the context.
        LibraryUtils libraryUtils = context.getBean(LibraryUtils.class);
        // Use the LibraryUtils bean to find a book by its id.
        String bookTitle = libraryUtils.findBook(1);
        // Print the title of the book found.
        System.out.println("Book title: " + bookTitle);
        // Get the Reservation bean from the context.
        Reservation reservation = context.getBean(Reservation.class);
        // Print the details of the reservation.
        System.out.println("Reservation: " + reservation.toString());
    }
}

