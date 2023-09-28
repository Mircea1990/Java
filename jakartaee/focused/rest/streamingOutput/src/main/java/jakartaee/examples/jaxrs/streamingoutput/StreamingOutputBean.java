package jakartaee.examples.jaxrs.streamingoutput;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;

/**
 * A JAX-RS bean for use with the StreamingOutput example.
 */
@Path("streamingOutput") public class StreamingOutputBean {

    /**
     * Get method.
     *
     * @return "And we used StreamingOutput"
     */
    @GET @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_PLAIN)
    public Response get() {
        StreamingOutput stream = (OutputStream os) -> {
            Writer writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write("And we used StreamingOutput");
            writer.flush();
        };
        return Response.ok(stream).build();
    }
}
