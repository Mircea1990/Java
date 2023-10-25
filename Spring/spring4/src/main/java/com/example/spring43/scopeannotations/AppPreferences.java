package com.example.spring43.scopeannotations;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

// This is a public class named AppPreferences that extends the InstanceCountingService class.
// It is annotated with @Component and @ApplicationScope.
// @Component annotation is used to indicate that it's a component in the Spring framework.
// @ApplicationScope annotation indicates that a single instance should be created and shared for
// the entire application.
@Component @ApplicationScope public class AppPreferences extends InstanceCountingService {}
