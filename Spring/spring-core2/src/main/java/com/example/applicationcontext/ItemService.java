package com.example.applicationcontext;

import org.springframework.stereotype.Service;

// This class is a service component
@Service public class ItemService {
    // This method returns a string representing an item
    public String getItem() {
        return "New Item";
    }
}
