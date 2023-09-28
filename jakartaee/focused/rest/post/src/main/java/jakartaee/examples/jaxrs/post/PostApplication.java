package jakartaee.examples.jaxrs.post;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the JAX-RS @POST example.
 */
@ApplicationPath("rest") public class PostApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(PostResource.class);
        return classes;
    }
}
