package main.java;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static java.lang.System.getProperty;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;

/*
ITBase serves as a base class for integration testing using the Arquillian framework.
 */
@RunWith(Arquillian.class) public abstract class ITBase {

    /*
    This field is annotated with @ArquillianResource and represents the URL of the deployed
    application. It is injected by Arquillian, allowing access to the deployed application's URL
    during test execution.
     */
    @ArquillianResource protected URL webUrl;

    /*
    This field represents the WebClient instance from the HtmlUnit library, which is a headless
    browser used for simulating user interactions and retrieving web pages in integration tests.
     */
    protected WebClient webClient;

    /*
     @Deployment(testable = false): This annotation is used to define the deployment configuration
      for the test. In this case,
     testable = false indicates that the deployment should not be run in a test environment.
     */
    @Deployment(testable = false)
    /*
    This method is responsible for creating the deployment archive that will be used for testing.
     It uses Arquillian's create() method to create a WebArchive by importing the WAR file
     generated during the build process.
     */ public static WebArchive createDeployment() {
        return create(ZipImporter.class, getProperty("finalName") + ".war").importFrom(
                new File("target/" + getProperty("finalName") + ".war")).as(WebArchive.class);
    }

    /*
    This method is annotated with @Before and is executed before each test method. It initializes
     the WebClient, enabling JavaScript support and configuring some options for the WebClient
     instance.
     */
    @Before public void setUp() {
        webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.setJavaScriptTimeout(120000);
        webClient.setIncorrectnessListener(new src.main.java.IgnoringIncorrectnessListener());
        src.main.java.DebugOptions.setDebugOptions(webClient);
    }

    /*
    This method is used to retrieve an HtmlPage by navigating to the specified URL, which is
    constructed by appending the viewId to the webUrl. This method is typically used to simulate
    user interactions and retrieve the resulting web page for assertions in integration tests.
     */
    protected HtmlPage getPage(String viewId) throws IOException {
        return webClient.getPage(webUrl + viewId);
    }

    /*
    This method is annotated with @After and is executed after each test method. It closes the
    WebClient instance, releasing any associated resources.
     */
    @After public void tearDown() {
        webClient.close();
    }

}
