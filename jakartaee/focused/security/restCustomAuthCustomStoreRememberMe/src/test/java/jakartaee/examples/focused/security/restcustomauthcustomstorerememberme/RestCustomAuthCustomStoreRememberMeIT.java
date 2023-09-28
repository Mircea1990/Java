package jakartaee.examples.focused.security.restcustomauthcustomstorerememberme;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

import jakartaee.examples.utils.ITBase;


/**
 * The integration test for the REST with a custom authentication mechanism, a custom store and
 * remember-me example.
 */
@RunWith(Arquillian.class) @RunAsClient public class RestCustomAuthCustomStoreRememberMeIT
        extends ITBase {

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

        // Remove all cookies (specially the JSESSONID), except for the
        // JREMEMBERMEID cookie which carries the token to login again
        for (Cookie cookie : webClient.getCookieManager().getCookies()) {
            if (!"JREMEMBERMEID".equals(cookie.getName())) {
                webClient.getCookieManager().removeCookie(cookie);
            }
        }

        // Remove the request headers that we set to provide the name and password
        webClient.removeRequestHeader("callername");
        webClient.removeRequestHeader("callerpassword");

        // Should get the resource response, and not the login form
        TextPage pageAgain = webClient.getPage(baseUrl + "/rest/resource");

        System.out.println(pageAgain.getContent());
    }
}
