package com.example.spring43.scopeannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// The @RestController annotation is used to define a controller and indicate that the return
// value of the methods should be bound to the web response body.
// The @RequestMapping("/appointments") annotation is used to map web requests onto specific
// handler classes and/or handler methods.
@RestController @RequestMapping("/appointments") public class ScopeTestController {

    // The @Autowired annotation is used for automatic dependency injection.
    // Here it's injecting an instance of LoginAction, UserPreferences, and AppPreferences.
    @Autowired private LoginAction loginAction;
    @Autowired private UserPreferences userPreferences;
    @Autowired private AppPreferences appPreferences;

    // The @GetMapping("/request") annotation ensures that HTTP GET requests to
    // /appointments/request are mapped to the getRequestNumber() method.
    // This method returns the instance number of the current login action.
    @GetMapping("/request") public String getRequestNumber() {
        return Integer.toString(loginAction.getInstanceNumber());
    }

    // The @GetMapping("/session") annotation ensures that HTTP GET requests to
    // /appointments/session are mapped to the getSessionNumber() method.
    // This method returns the instance number of the current user preferences.
    @GetMapping("/session") public String getSessionNumber() {
        return Integer.toString(userPreferences.getInstanceNumber());
    }

    // The @GetMapping("/application") annotation ensures that HTTP GET requests to
    // /appointments/application are mapped to the getApplicationNumber() method.
    // This method returns the instance number of the current application preferences.
    @GetMapping("/application") public String getApplicationNumber() {
        return Integer.toString(appPreferences.getInstanceNumber());
    }
}

