package jakartaee.examples.servlet.httpsessionattributelistener;

import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 * An example HttpSessionAttributeListener.
 */
@WebListener(value = "A example HttpSessionAttributeListener")
public class HttpSessionAttributeListenerExample implements HttpSessionAttributeListener {

    /**
     * Stores the servlet context.
     */
    @Inject ServletContext servletContext;

    /**
     * Handle the attribute added event.
     *
     * @param event the event.
     */
    @Override public void attributeAdded(HttpSessionBindingEvent event) {
        servletContext.setAttribute("attributeAdded", event.getName());
        servletContext.setAttribute("attributeAddedValue", event.getValue());
    }

    /**
     * Handle the attribute removed event.
     *
     * @param event the event.
     */
    @Override public void attributeRemoved(HttpSessionBindingEvent event) {
        servletContext.setAttribute("attributeRemoved", event.getName());
    }

    /**
     * Handle the attribute replaced event.
     *
     * @param event the event.
     */
    @Override public void attributeReplaced(HttpSessionBindingEvent event) {
        servletContext.setAttribute("attributeReplaced", event.getName());
        servletContext.setAttribute("attributeReplacedValue", event.getValue());
    }
}
