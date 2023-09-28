package jakartaee.examples.focused.security.restbasicauthdbstoreandcustomstore;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.TextPage;

import jakartaee.examples.utils.ITBase;


/**
 * The integration test for the REST with basic authentication and database and custom store
 * example
 */
@RunWith(Arquillian.class) @RunAsClient public class RestBasicAuthDBStoreAndCustomStoreIT
        extends ITBase {

    @ArquillianResource private URL baseUrl;

    /**
     * Test the call to a protected REST service
     *
     * <p>
     * This will use the "john" credentials, which should be validated by the DB store
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testRestCall1() throws Exception {
        DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();
        credentialsProvider.addCredentials("john", "secret1");

        webClient.setCredentialsProvider(credentialsProvider);

        TextPage page = webClient.getPage(baseUrl + "/rest/resource");
        String content = page.getContent();

        System.out.println(content);
    }

    /**
     * Test the call to a protected REST service
     *
     * <p>
     * This will use the "pete" credentials, which should be validated by the custom store
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testRestCall2() throws Exception {
        DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();
        credentialsProvider.addCredentials("pete", "secret2");

        webClient.setCredentialsProvider(credentialsProvider);

        TextPage page = webClient.getPage(baseUrl + "/rest/resource");
        String content = page.getContent();

        System.out.println(content);
    }
}
