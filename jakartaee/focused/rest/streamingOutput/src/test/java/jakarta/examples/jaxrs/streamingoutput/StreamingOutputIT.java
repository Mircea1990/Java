package jakarta.examples.jaxrs.streamingoutput;

import static org.junit.Assert.assertTrue;

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
 * The JUnit tests for the h:outputText example.
 */
@RunWith(Arquillian.class) @RunAsClient public class StreamingOutputIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the h:outputText.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testOutputText() throws Exception {
        HtmlPage page = webClient.getPage(baseUrl);
        TextPage textPage = page.getElementById("form:submit").click();
        assertTrue(textPage.getContent().contains("And we used StreamingOutput"));
    }
}
