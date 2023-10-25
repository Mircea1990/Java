package com.example.flips.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// The @Data annotation is a Lombok annotation to create all the getters, setters, equals, hash,
// and toString methods, based on the fields.
// The @RequiredArgsConstructor annotation is a Lombok annotation which generates a constructor
// with required fields. Required fields are final fields and fields with constraints such as
// @NonNull.
@Data @RequiredArgsConstructor public class Foo {
    // The @NonNull annotation is used to indicate that a null value is not allowed.
    // This field 'name' will be included in the generated constructor due to the @NonNull
    // annotation.
    @NonNull private final String name;

    // This field 'id' will be included in the generated constructor because it's declared as final.
    private final int id;
}

