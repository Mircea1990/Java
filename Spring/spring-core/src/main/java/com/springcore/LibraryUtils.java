package com.springcore;

import com.springcore.EbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryUtils {
    @Autowired
    private EbookRepository eBookRepository;

    public String findBook(int id) {
        return eBookRepository.titleById(id);
    }
}
