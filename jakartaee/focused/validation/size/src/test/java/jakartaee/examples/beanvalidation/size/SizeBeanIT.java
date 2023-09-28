package jakartaee.examples.beanvalidation.size;

import static org.junit.Assert.assertFalse;
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
 * The JUnit tests for the BeanValidation @Size example.
 */
@RunWith(Arquillian.class) @RunAsClient public class SizeBeanIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the @Size.
     *
     * @throws Exception when a serious error occurs.
     */
    @Test public void testSize() throws Exception {
        HtmlPage page = webClient.getPage(baseUrl + "index.xhtml");
        String content = page.asXml();
        assertTrue(content.contains("This example demonstrates the use of @Size"));

        HtmlInput inputText = (HtmlInput) page.getElementByName("form:inputText");
        inputText.type("1234");
        page = page.getElementByName("form:submitButton").click();
        assertFalse(page.asXml().contains("size must be"));

        inputText = (HtmlInput) page.getElementByName("form:inputText");
        inputText.setValueAttribute("123");
        page = page.getElementByName("form:submitButton").click();
        assertTrue(page.asXml().contains("size must be"));
    }
}
