package jakartaee.examples.jaxrs.consumes;

import java.io.IOException;
import java.net.URL;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * The request scoped bean to submit to JAX-RS @Consumes resource.
 */
@Named @RequestScoped public class ConsumesHelperBean {

    /**
     * Stores the HTTP servlet request.
     */
    @Inject private HttpServletRequest request;

    /**
     * Stores the output.
     */
    private String output;

    /**
     * Get the output.
     *
     * @return the output.
     */
    public String getOutput() {
        return output;
    }

    /**
     * Set the output.
     *
     * @param output the output.
     */
    public void setOutput(String output) {
        this.output = output;
    }

    /**
     * Submit to the @Consumes bean.
     *
     * @return ""
     */
    public String submit() {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut(
                    new URL(request.getScheme(), request.getServerName(), request.getServerPort(),
                            request.getContextPath()).toString() + "/rest/consumes");
            httpPut.addHeader("Content-Type", "application/json");
            httpPut.setEntity(new StringEntity(
                    "{\"string\":\"And we used @Consumes to consume a JSON string\"}"));
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            output = httpclient.execute(httpPut, responseHandler);
        } catch (IOException ioe) {
            output = ioe.getMessage();
        }
        return "";
    }
}
