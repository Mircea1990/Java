package jakartaee.examples.servlet.servletrequestlistener;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import jakartaee.examples.utils.ITBase;

/**
 * The JUnit tests for the Servlet API ServletContextListener example.
 */
@RunWith(Arquillian.class) @RunAsClient public class ServletRequestListenerIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the ServletContextListener example.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testServletContextListener() throws Exception {
        HtmlPage page = webClient.getPage(baseUrl + "index.xhtml");
        String content = page.asXml();
        assertTrue(content.contains("Did our ServletRequestListener get called: true"));
    }
}
