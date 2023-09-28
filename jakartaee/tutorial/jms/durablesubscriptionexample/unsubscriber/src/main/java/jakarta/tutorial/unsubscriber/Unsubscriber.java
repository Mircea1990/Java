package jakarta.tutorial.unsubscriber;

import jakarta.annotation.Resource;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSRuntimeException;

public class Unsubscriber {

    @Resource(lookup = "jms/DurableConnectionFactory") private static ConnectionFactory
            durableConnectionFactory;

    public static void main(String[] args) {
        try (JMSContext context = durableConnectionFactory.createContext();) {
            System.out.println("Unsubscribing from durable subscription");
            context.unsubscribe("MakeItLast");
        } catch (JMSRuntimeException e) {
            System.err.println("Exception occurred: " + e.toString());
            System.exit(1);
        }
        System.exit(0);
    }
}
