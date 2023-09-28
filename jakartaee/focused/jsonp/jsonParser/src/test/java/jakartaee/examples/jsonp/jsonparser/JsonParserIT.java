package jakartaee.examples.jsonp.jsonparser;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import jakartaee.examples.utils.ITBase;

/**
 * The JUnit tests for the JsonParserBean class.
 */
@RunWith(Arquillian.class) @RunAsClient public class JsonParserIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the JsonParserBean.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testJsonParserBean() throws Exception {
        HtmlPage page = webClient.getPage(baseUrl + "index.xhtml");

        HtmlInput input = page.getHtmlElementById("form:inputText");
        input.type("{}");
        page = page.getElementByName("form:submitButton").click();
        assertTrue(page.asXml().contains("START_OBJECT"));
        assertTrue(page.asXml().contains("END_OBJECT"));
    }
}
