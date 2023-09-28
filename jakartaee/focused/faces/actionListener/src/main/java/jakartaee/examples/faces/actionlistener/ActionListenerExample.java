package java.jakartaee.examples.faces.actionlistener;

import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ActionListener;

/**
 * The ActionListener for the f:actionListener example.
 */
public class ActionListenerExample implements ActionListener {

    /**
     * Process the action.
     *
     * @param event the event.
     * @throws AbortProcessingException when asked to abort the rest of the processing.
     */
    @Override public void processAction(ActionEvent event) throws AbortProcessingException {
        throw new AbortProcessingException("We stopped here!");
    }
}
