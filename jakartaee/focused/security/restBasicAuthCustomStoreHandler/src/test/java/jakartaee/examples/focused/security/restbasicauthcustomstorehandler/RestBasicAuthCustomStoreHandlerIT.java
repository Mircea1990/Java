package jakartaee.examples.focused.security.restbasicauthcustomstorehandler;

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
 * The integration test for the REST with basic authentication and database and custom store and
 * custom store handler example.
 */
@RunWith(Arquillian.class) @RunAsClient public class RestBasicAuthCustomStoreHandlerIT
        extends ITBase {

    @ArquillianResource private URL baseUrl;

    /**
     * Test the call to a protected REST service
     *
     * <p>
     * This will use the "john" credentials, which should be validated by both the DB store and the
     * custom store, as per the custom identity store handler.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testRestCall1() throws Exception {
        DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();
        credentialsProvider.addCredentials("john", "secret1");

        webClient.setCredentialsProvider(credentialsProvider);

        TextPage page = webClient.getPage(baseUrl + "rest/resource");
        String content = page.getContent();

        System.out.println(content);
    }

}
