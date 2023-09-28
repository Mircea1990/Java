package jakartaee.examples.focused.servlet.relogin;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.TextPage;

import jakartaee.examples.utils.ITBase;

/**
 * The JUnit tests for the relogin classes
 */
@RunWith(Arquillian.class) @RunAsClient public class ReloginIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the relogin
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testRelogin() throws Exception {
        TextPage page = webClient.getPage(baseUrl);

        System.out.println(page.getContent());

        assertTrue(page.getContent().contains("1:john"));
        assertTrue(page.getContent().contains("1:true"));
    }
}
