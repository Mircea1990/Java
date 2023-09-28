package jakartaee.examples.jaxrs.formparam;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the JAX-RS @FormParam example.
 */
@ApplicationPath("rest") public class FormParamApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(FormParamResource.class);
        return classes;
    }
}
