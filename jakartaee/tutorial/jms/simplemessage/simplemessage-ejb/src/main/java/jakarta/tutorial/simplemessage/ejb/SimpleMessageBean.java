package jakarta.tutorial.simplemessage.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.annotation.Resource;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.ejb.MessageDrivenContext;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destinationLookup",
                                                             propertyValue = "jms/MyQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",
                                  propertyValue = "jakarta.jms.Queue")})
public class SimpleMessageBean implements MessageListener {

    static final Logger logger = Logger.getLogger("SimpleMessageBean");
    @Resource private MessageDrivenContext mdc;

    public SimpleMessageBean() {
    }

    @Override public void onMessage(Message inMessage) {

        try {
            if (inMessage instanceof TextMessage) {
                logger.log(Level.INFO, "MESSAGE BEAN: Message received: {0}",
                           inMessage.getBody(String.class));
            } else {
                logger.log(Level.WARNING, "Message of wrong type: {0}",
                           inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            logger.log(Level.SEVERE, "SimpleMessageBean.onMessage: JMSException: {0}",
                       e.toString());
            mdc.setRollbackOnly();
        }
    }
}
