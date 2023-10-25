package com.example.flips.controller;

import com.example.flips.model.Foo;
import com.example.flips.service.FlipService;
import org.flips.annotation.FlipOnDateTime;
import org.flips.annotation.FlipOnDaysOfWeek;
import org.flips.annotation.FlipOnEnvironmentProperty;
import org.flips.annotation.FlipOnProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.List;

// The @RestController annotation is used to define a controller and indicates that the return
// value of the methods should be bound to the web response body.
@RestController public class FlipController {
    // An instance of FlipService is declared. It's used to call the methods defined in the service.
    private final FlipService flipService;

    // The @Autowired annotation is used to automatically wire the FlipService into this controller.
    @Autowired public FlipController(FlipService flipService) {
        this.flipService = flipService;
    }

    // This method is mapped to the GET request method for the "/foos" URL. It returns a list of
    // all Foo objects.
    // The @FlipOnProfiles annotation indicates that this method should only be active when the
    // "dev" profile is active.
    @RequestMapping(value = "/foos", method = RequestMethod.GET)
    @FlipOnProfiles(activeProfiles = "dev") public List<Foo> getAllFoos() {
        return flipService.getAllFoos();
    }

    // This method is mapped to the GET request method for the "/foo/{id}" URL. It returns a Foo
    // object with the given id.
    // The @FlipOnDaysOfWeek annotation indicates that this method should only be active on the
    // specified days of the week.
    @RequestMapping(value = "/foo/{id}", method = RequestMethod.GET) @FlipOnDaysOfWeek(
            daysOfWeek = {DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY})
    public Foo getFooByNewId(@PathVariable int id) {
        return flipService.getFooById(id).orElse(new Foo("Not Found", -1));
    }

    // This method is mapped to the GET request method for the "/foo/last" URL. It returns the
    // last Foo object.
    // The @FlipOnDateTime annotation indicates that this method should only be active after a
    // certain date and time.
    @RequestMapping(value = "/foo/last", method = RequestMethod.GET)
    @FlipOnDateTime(cutoffDateTimeProperty = "last.active.after") public Foo getLastFoo() {
        return flipService.getLastFoo();
    }

    // This method is mapped to the GET request method for the "/foo/first" URL. It returns the
    // first Foo object.
    // The @FlipOnDateTime annotation indicates that this method should only be active after a
    // certain date and time.
    @RequestMapping(value = "/foo/first", method = RequestMethod.GET)
    @FlipOnDateTime(cutoffDateTimeProperty = "first.active.after") public Foo getFirstFoo() {
        return flipService.getLastFoo();
    }

    // This method is mapped to the GET request method for the "/foos/{id}" URL. It returns a Foo
    // object with the given id.
    // The @FlipOnEnvironmentProperty annotation indicates that this method should only be active
    // when a certain environment property has a certain value.
    @RequestMapping(value = "/foos/{id}", method = RequestMethod.GET)
    @FlipOnEnvironmentProperty(property = "feature.foo.by.id", expectedValue = "Y")
    public Foo getFooById(@PathVariable int id) {
        return flipService.getFooById(id).orElse(new Foo("Not Found", -1));
    }

    // This method is mapped to the GET request method for the "/foo/new" URL. It returns a new
    // Foo object.
    @RequestMapping(value = "/foo/new", method = RequestMethod.GET) public Foo getNewThing() {
        return flipService.getNewFoo();
    }
}
