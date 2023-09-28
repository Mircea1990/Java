package jakarta.tutorial.durableconsumer;

import jakarta.jms.JMSException;
import jakarta.jms.JMSRuntimeException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

/**
 * The TextListener class implements the MessageListener interface by defining an onMessage method
 * that displays the contents of a TextMessage.
 * <p>
 * This class acts as the listener for the AsynchConsumer class.
 */
public class TextListener implements MessageListener {

    /**
     * Displays the message text.
     *
     * @param message the incoming message
     */
    @Override public void onMessage(Message m) {
        try {
            if (m instanceof TextMessage) {
                System.out.println("Reading message: " + m.getBody(String.class));
            } else {
                System.out.println("Message is not a TextMessage");
            }
        } catch (JMSException | JMSRuntimeException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        }
    }
}
