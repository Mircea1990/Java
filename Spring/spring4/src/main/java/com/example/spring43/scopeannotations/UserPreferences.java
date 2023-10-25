package com.example.spring43.scopeannotations;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

// The @Component annotation is used to indicate that a class is a "component".
// These classes are considered as candidates for auto-detection when using annotation-based
// configuration and classpath scanning.
@Component

// The @SessionScope annotation is used to specify that a bean should be scoped at the HTTP
// session level.
// This means that the same instance of the bean will be returned each time it is requested
// within the same HTTP session.
@SessionScope

// Here, UserPreferences is a component that's available in the HTTP session scope.
// It extends InstanceCountingService, which means it inherits all the methods and properties of
// InstanceCountingService.
public class UserPreferences extends InstanceCountingService {}
