package com.springcore;

import jakarta.persistence.Entity;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

// The @Getter annotation is a Lombok annotation to auto-generate getter methods for all fields.
// The @Component annotation indicates that this class is a component.
// A component is a Java class that is detected and automatically registered as a bean in the
// Spring IoC container.
// The @Entity annotation specifies that the class is an entity and is mapped to a database table.
@Getter @Component @Entity public class Ebook {
    // These are fields for the Ebook class which correspond to columns in the database table.
    private int bookId;
    private String bookTitle;
    // The @Id annotation specifies the primary key of an entity.
    @Id private Long id;

    // Setter method for bookId. It sets the value of bookId.
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Setter method for bookTitle. It sets the value of bookTitle.
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    // Setter method for id. It sets the value of id.
    public void setId(Long id) {
        this.id = id;
    }
}

