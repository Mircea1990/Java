package jakartaee.examples.servlet.httpsessionlistener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * An example HttpSessionListener.
 */
@WebListener(value = "A example HttpSessionListener") public class HttpSessionListenerExample
        implements HttpSessionListener {

    /**
     * Handles the session created event.
     *
     * @param event the HTTP session event.
     */
    @Override public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " was created");
    }

    /**
     * Handles the session destroyed event.
     *
     * @param event the HTTP session event.
     */
    @Override public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session " + event.getSession().getId() + " was destroyed");
    }
}
