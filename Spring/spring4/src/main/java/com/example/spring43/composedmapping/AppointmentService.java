package com.example.spring43.composedmapping;

import java.util.Map;

// This is an interface for a service that handles operations related to appointments.
public interface AppointmentService {

    // This method, when implemented, should return a Map where the keys are Strings
    // (possibly representing appointment IDs or some other identifier) and the values
    // are Appointment objects. The returned map should represent all appointments scheduled for
    // today.
    Map<String, Appointment> getAppointmentsForToday();
}

