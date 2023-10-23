package com.springcore;

import com.springcore.streamutils.CopyStream;
import com.springcore.streamutils.DrainStream;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.springcore");
        // Use CopyStream
        CopyStream copyStream = context.getBean(CopyStream.class);
        String content = CopyStream.getStringFromInputStream(copyStream.getNonClosingInputStream());
        System.out.println("Content from input stream: " + content);
        // Use DrainStream
        DrainStream drainStream = context.getBean(DrainStream.class);
        InputStream inputStream = drainStream.getInputStream();
        System.out.println("Input stream is null: " + (inputStream == null));
        // Use LibraryUtils
        LibraryUtils libraryUtils = context.getBean(LibraryUtils.class);
        String bookTitle = libraryUtils.findBook(1);
        System.out.println("Book title: " + bookTitle);
        // Use Reservation
        Reservation reservation = context.getBean(Reservation.class);
        System.out.println("Reservation: " + reservation.toString());
    }
}
