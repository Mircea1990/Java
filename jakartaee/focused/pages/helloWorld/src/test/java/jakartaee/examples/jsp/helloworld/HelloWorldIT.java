package jakartaee.examples.jsp.helloworld;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import jakartaee.examples.utils.ITBase;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * The JUnit tests for the JSP HelloWorld example.
 */
@RunWith(Arquillian.class) @RunAsClient public class HelloWorldIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;


    /**
     * Test the Pages HelloWorld example.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testHelloWorld() throws Exception {
        HtmlPage page = webClient.getPage(baseUrl);
        assertTrue(page.asXml().contains("Hello World!"));
    }
}
