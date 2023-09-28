package java.jakartaee.examples.faces.applicationscoped;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;

/**
 * An application scoped bean.
 */
@Named(value = "applicationScopedBean") @ApplicationScoped public class ApplicationScopedBean
        implements Serializable {

    /**
     * Stores the time.
     */
    private String time;

    /**
     * Initialize the bean.
     */
    @PostConstruct public void initialize() {
        time = new Date().toString() + " - " + System.nanoTime();
    }

    /**
     * Get the time.
     *
     * @return the time.
     */
    public String getTime() {
        return time;
    }
}
