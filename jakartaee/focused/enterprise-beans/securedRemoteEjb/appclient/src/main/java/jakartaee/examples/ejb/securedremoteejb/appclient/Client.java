package java.jakartaee.examples.ejb.securedremoteejb.appclient;

import jakarta.ejb.EJB;
import jakartaee.examples.ejb.securedremoteejb.SecuredRemoteEjb;

/**
 * A secured remote EJB application client.
 */
public class Client {

    /**
     * Stores the remote EJB.
     */
    @EJB private static SecuredRemoteEjb ejb;

    /**
     * Main method.
     *
     * <p>
     * If you are executing this on Glassfish / Payara deploy the EAR to the server first then build
     * the client application, and then go into the target directory and execute the command line
     * mentioned below.
     * </p>
     *
     * <pre>
     *   appclient -client appclient-8-SNAPSHOT.jar -user securedRemoteEjbUser -password password
     * </pre>
     *
     * <p>
     * Note this assumes you have setup the username 'securedRemoteEjbUser' with password 'password'
     * in the 'file' realm.
     * </p>
     *
     * @param arguments
     */
    public static void main(String[] arguments) {
        Client main = new Client();
        main.run();
    }

    /**
     * Run method.
     */
    public void run() {
        System.out.println(ejb.helloWorld());
    }
}
