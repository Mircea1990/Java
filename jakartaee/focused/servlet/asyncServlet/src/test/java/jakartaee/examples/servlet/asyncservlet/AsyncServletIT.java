package jakartaee.examples.servlet.asyncservlet;

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
 * The JUnit tests for the Servlet API asynchronous Servlet example.
 */
@RunWith(Arquillian.class) @RunAsClient public class AsyncServletIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the @WebServlet annotation.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testWebServletAnnotation() throws Exception {
        TextPage page = webClient.getPage(baseUrl);
        String content = page.getContent();
        assertTrue(content.contains("OK"));
    }
}
