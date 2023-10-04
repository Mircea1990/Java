package jakartaee.examples.jaxrs.helloworld;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

/**
 * A request scoped bean for the JAX-RS HelloWorld example.
 */
@ApplicationPath("rest") public class HelloWorldApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(HelloWorldResource.class);
        return classes;
    }
}
