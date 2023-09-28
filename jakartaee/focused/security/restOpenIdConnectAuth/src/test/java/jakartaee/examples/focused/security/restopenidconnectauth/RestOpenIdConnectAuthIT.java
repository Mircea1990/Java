package jakartaee.examples.focused.security.restopenidconnectauth;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import jakartaee.examples.utils.ITBase;


/**
 * The integration test for the REST with OpenID Connect authentication example
 */
@RunWith(Arquillian.class) @RunAsClient public class RestOpenIdConnectAuthIT extends ITBase {

    @ArquillianResource private URL baseUrl;

    /**
     * Test the call to a protected REST service
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testRestCall() throws Exception {
        HtmlPage page = webClient.getPage(baseUrl + "/rest/resource");

        // Authenticate with the OpenId Provider using the username and password for a default user
        page.getElementById("j_username").setAttribute("value", "user");

        page.getElementById("j_password").setAttribute("value", "password");

        // Submit login form
        HtmlPage confirmationPage = page.getElementByName("submit").click();

        System.out.println(confirmationPage.asXml());

        // Confirm: the OpenId Provider confirmation page has an "authorize" button which then
        // redirects us back to our Jakarta EE server, which then redirects us to the originally
        // requested resource.
        TextPage originalResource = confirmationPage.getElementByName("authorize").click();

        System.out.println(originalResource.getContent());
    }
}
