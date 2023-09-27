package main.java;

import com.gargoylesoftware.htmlunit.TextPage;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class) @RunAsClient public class HttpServletMappingServletIT extends ITBase {

    /**
     * Stores the base URL.
     */
    @ArquillianResource private URL baseUrl;

    /**
     * Test the HTTP servlet mapping.
     *
     * @throws Exception when a serious error occurs.
     */
    @RunAsClient @Test public void testHttpServletMapping() throws Exception {
        TextPage page = webClient.getPage(baseUrl);
        String content = page.getContent();
        assertTrue(
                content.contains("jakartaee.servlet.httpservletmapping.HttpServletMappingServlet"));
        assertTrue(content.contains("/*"));
        assertTrue(content.contains("PATH"));
    }
}
