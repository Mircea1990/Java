package com.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The @Component annotation is a Spring Framework annotation to indicate that a class is a
// "component".
// These classes are considered as candidates for auto-detection when using annotation-based
// configuration and classpath scanning.
@Component public class Reservation {
    // Member variable for storing member object
    private Member member;
    // Member variable for storing eBook object
    private Ebook eBook;

    // The @Autowired annotation is used to auto-wire spring bean on setter methods, constructor,
    // and instance variable.
    // Here it's used on a constructor, Spring will inject an instance of Member and Ebook here
    // when Reservation object is created.
    @Autowired public Reservation(Member member, Ebook eBook) {
        this.member = member;
        this.eBook = eBook;
    }
}

