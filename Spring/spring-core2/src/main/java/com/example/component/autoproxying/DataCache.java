package com.example.component.autoproxying;

import lombok.Getter;
import org.springframework.stereotype.Component;

// This class represents a DataCache and is a Spring component
@Component @Getter public class DataCache {
    // This field is annotated with @RandomInt, indicating that it will be assigned a random
    // integer value within the specified range
    @RandomInt(min = 2, max = 10) private int group;
    // This field represents the name of the DataCache
    private String name;
}
