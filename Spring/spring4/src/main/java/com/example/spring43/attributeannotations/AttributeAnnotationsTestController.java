package com.example.spring43.attributeannotations;

import org.springframework.web.bind.annotation.*;

// @RestController is a convenience annotation that is itself annotated with @Controller and
// @ResponseBody.
// This annotation is used at the class level and indicates that the return value of the methods
// should be bound to the web response body.
@RestController

// @RequestMapping is used to map web requests onto specific handler classes or handler methods.
// In this case, it's mapping all requests with the path "/test" to this controller.
@RequestMapping("/test")

public class AttributeAnnotationsTestController {

    // @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method =
    // RequestMethod.GET).
    // It's used to handle HTTP GET requests and can be used at both class and method levels.
    @GetMapping

    // The method 'get' is mapped to handle HTTP GET requests for the "/test" path due to the
    // class level @RequestMapping and method level @GetMapping.
    // The parameters of this method are annotated with @SessionAttribute and @RequestAttribute.
    public String get(
            // @SessionAttribute is used to bind a method parameter to a session attribute.
            // The session attribute 'login' will be bound to the parameter 'login'.
            @SessionAttribute String login,

            // @RequestAttribute is used to bind a method parameter to a request attribute.
            // The request attribute 'query' will be bound to the parameter 'query'.
            @RequestAttribute String query) {

        // The method returns a formatted string containing the values of 'login' and 'query'.
        return String.format("login = %s, query = %s", login, query);
    }
}
