package com.example.spring43.composedmapping;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

// The @Controller annotation indicates that the class is a "Controller"
// (a web request handler) in a Spring MVC application.
@Controller

// The @RequestMapping annotation is used to map web requests onto specific handler classes
// and/or handler methods.
// "/appointments" is the path that this controller will handle.
@RequestMapping("/appointments") public class AppointmentsController {

    // An instance of AppointmentService to handle business logic related to appointments.
    private final AppointmentService appointmentService;

    // The @Autowired annotation is used for automatic dependency injection.
    // Here, it's injecting an instance of a Logger to handle logging.
    @Autowired private Logger logger;

    // Constructor for the AppointmentsController.
    // The @Autowired annotation means Spring will inject an instance of AppointmentService here.
    @Autowired public AppointmentsController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // The @GetMapping annotation is a composed annotation that acts as a shortcut for
    // @RequestMapping(method = GET).
    // This method will be invoked in response to a GET request on "/appointments".
    @GetMapping public Map<String, Appointment> get() {
        // Log the action of getting appointments.
        logger.info("Getting appointments...");

        // Return the appointments for today using the appointmentService.
        return appointmentService.getAppointmentsForToday();
    }
}
