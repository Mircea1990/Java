package jakartaee.examples.faces.viewmap;

import static org.junit.Assert.assertFalse;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import jakartaee.examples.utils.ITBase;

/**
 * The JUnit tests for the injected ViewMap example.
 */
@RunWith(Arquillian.class) @RunAsClient public class ViewMapIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the injected ViewMap.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testInjectedViewMap() throws Exception {
        HtmlPage page = webClient.getPage(baseUrl);
        assertFalse(page.asXml().contains("__''__"));
    }
}
