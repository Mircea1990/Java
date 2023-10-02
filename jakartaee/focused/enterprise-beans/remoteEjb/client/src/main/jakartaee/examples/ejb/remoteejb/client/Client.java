package jakartaee.examples.ejb.remoteejb.client;

import javax.naming.InitialContext;
import jakartaee.examples.ejb.remoteejb.RemoteEjb;

/**
 * The remoteEjb client.
 */
public class Client {

    /**
     * Main method.
     *
     * <p>
     * If you are running this on Glassfish/Payara and you want to connect to a specific host the
     * following properties would need to be used with the InitialContext.
     * </p>
     * <pre>
     *  properties.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
     *  properties.put("org.omg.CORBA.ORBInitialHost", "localhost");
     *  properties.put("org.omg.CORBA.ORBInitialPort", "3700");
     * </pre>
     *
     * @param arguments the arguments.
     * @throws Exception when an error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        InitialContext initialContext = new InitialContext();
        RemoteEjb ejb = (RemoteEjb) initialContext.lookup(
                "java:global/remoteEjb/remoteEjbJar/remoteEjb");
        System.out.println(ejb.helloWorld());
    }
}
