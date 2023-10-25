package com.example.jsonp.web.controller;

import com.example.jsonp.model.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// The @Controller annotation indicates that the class can be used by Spring MVC to handle web
// requests.
@Controller public class CompanyController {

    // The @RequestMapping annotation is used to map web requests onto specific handler methods.
    // Here it's mapping any requests with the value "/companyResponseBody" and producing results
    // in APPLICATION_JSON_VALUE format.
    @RequestMapping(value = "/companyResponseBody", produces = MediaType.APPLICATION_JSON_VALUE)

    // The @ResponseBody annotation tells a controller that the object returned is automatically
    // serialized into JSON and passed back into the HttpResponse object.
    // Here it's used to return a Company object as a response body in JSON format.
    @ResponseBody public Company getCompanyResponseBody() {
        // Create a new Company object with id as 2 and name as "ABC".
        // Return the created Company object.
        return new Company(2, "ABC");
    }

    // Another @RequestMapping annotation mapping requests with the value
    // "/companyResponseEntity" and producing results in APPLICATION_JSON_VALUE format.
    @RequestMapping(value = "/companyResponseEntity", produces = MediaType.APPLICATION_JSON_VALUE)

    // This method returns a ResponseEntity. ResponseEntity represents the entire HTTP response.
    // Good for returning custom headers and status codes along with the response body.
    public ResponseEntity<Company> getCompanyResponseEntity() {
        // Create a new Company object with id as 3 and name as "123".
        final Company company = new Company(3, "123");
        // Return the created Company object wrapped inside a ResponseEntity with an HTTP status
        // code of OK (200).
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }
}

