package com.springcore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter @Component
@Entity
public class Ebook {
    private int bookId;
    private String bookTitle;
    @Id private Long id;

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
