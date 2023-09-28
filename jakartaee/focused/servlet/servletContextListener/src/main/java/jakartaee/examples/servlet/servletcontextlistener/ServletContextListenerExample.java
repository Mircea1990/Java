package jakartaee.examples.servlet.servletcontextlistener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * The ServletContextListener for the Servlet API ServletContextListener example.
 */
@WebListener(value = "A example ServletContextListener") public class ServletContextListenerExample
        implements ServletContextListener {

    /**
     * Handles the servlet context initialized event.
     *
     * @param event the servlet context initialized event.
     */
    @Override public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("contextInitializedCalled", "true");
    }
}
