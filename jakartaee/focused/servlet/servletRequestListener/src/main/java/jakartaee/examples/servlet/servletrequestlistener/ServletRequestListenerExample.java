package jakartaee.examples.servlet.servletrequestlistener;

import java.util.Date;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

/**
 * The ServletRequestListener for the Servlet API ServletRequestListener example.
 */
@WebListener(value = "A example ServletRequestListener") public class ServletRequestListenerExample
        implements ServletRequestListener {

    /**
     * A Servlet request is destroyed.
     *
     * @param event the event.
     */
    @Override public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("Request was desttroyed at: " + new Date());
        long startTime = (long) event.getServletRequest().getAttribute("startTime");
        System.out.println(
                "Request took " + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    /**
     * A Servlet request is initialized.
     *
     * @param event the event
     */
    @Override public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request was initialized at: " + new Date());
        event.getServletRequest().setAttribute("startTime", System.currentTimeMillis());
        event.getServletRequest().setAttribute("requestInitializedCalled", "true");
    }
}
