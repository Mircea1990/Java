package jakarta.tutorial.customer.resource;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("/webapi") public class CustomerApplication extends Application {
    @Override public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // register root resource
        classes.add(CustomerService.class);
        return classes;
    }
}
