package com.example.jsonp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// The @Controller annotation indicates that the class can be used by Spring MVC to handle web
// requests.
@Controller public class IndexController {

    // The @RequestMapping annotation is used to map web requests onto specific handler methods.
    // Here it's mapping any requests without a specific path to the 'retrieveIndex' method.
    @RequestMapping()

    // This method returns a String which represents the name of the view (in this case, "index").
    // When a handler method is annotated with @Controller, the String return type is interpreted
    // as the logical view name.
    public String retrieveIndex() {
        // Return the string "index".
        return "index";
    }
}

