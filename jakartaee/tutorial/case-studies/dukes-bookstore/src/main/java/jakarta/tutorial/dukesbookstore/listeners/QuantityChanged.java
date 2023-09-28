package jakarta.tutorial.dukesbookstore.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.event.ValueChangeListener;

/**
 * <p>Value change listener for the quantity entered on the
 * <code>bookshowcart.xhtml</code> page.</p>
 */
public class QuantityChanged extends Object implements ValueChangeListener {

    private static final Logger logger = Logger.getLogger(
            "dukesbookstore.listeners.QuantityChanged");

    @java.lang.Override public void processValueChange(ValueChangeEvent event)
            throws AbortProcessingException {
        logger.log(Level.INFO, "Entering QuantityChanged.processValueChange");
        if (null != event.getNewValue()) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("changed",
                                                                                       "true");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("changed",
                                                                                       "false");
        }
    }
}
