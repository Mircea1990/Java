package jakartaee.examples.focused.security.restcustomauthcustomstore;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.TextPage;

import jakartaee.examples.utils.ITBase;


/**
 * The integration test for the REST with a custom authentication mechanism and a custom store
 * example.
 */
@RunWith(Arquillian.class) @RunAsClient public class RestCustomAuthCustomStoreIT extends ITBase {

    @ArquillianResource private URL baseUrl;

    /**
     * Test the call to a protected REST service
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testRestCall() throws Exception {
        webClient.addRequestHeader("callername", "john");
        webClient.addRequestHeader("callerpassword", "secret1");

        TextPage page = webClient.getPage(baseUrl + "rest/resource");
        String content = page.getContent();

        System.out.println(content);
    }
}
