package com.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The @Component annotation indicates that this class is a component.
// A component is a Java class that is detected and automatically registered as a bean in the
// Spring IoC container.
@Component public class LibraryUtils {
    // The @Autowired annotation is used to auto-wire the EbookRepository bean into this class.
    // This means Spring will automatically inject an instance of EbookRepository into this class
    // when it is instantiated.
    @Autowired private EbookRepository eBookRepository;

    // This method uses the EbookRepository to find the title of a book given its id.
    public String findBook(int id) {
        return eBookRepository.titleById(id);
    }
}

