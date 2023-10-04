package jakartaee.examples.faces.sessionscoped;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Date;

/**
 * A session scoped bean.
 */
@Named(value = "sessionScopedBean") @SessionScoped public class SessionScopedBean
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
