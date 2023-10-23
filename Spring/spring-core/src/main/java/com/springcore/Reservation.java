package com.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Reservation {
    private Member member;
    private Ebook eBook;

    @Autowired
    public Reservation(Member member, Ebook eBook) {
        this.member = member;
        this.eBook = eBook;
    }
}
