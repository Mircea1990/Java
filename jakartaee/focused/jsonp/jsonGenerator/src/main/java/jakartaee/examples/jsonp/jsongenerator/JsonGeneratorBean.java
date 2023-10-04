package jakartaee.examples.jsonp.jsongenerator;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

import java.io.StringWriter;

/**
 * A request scoped bean for the JsonGenerator example.
 */
@Named @RequestScoped public class JsonGeneratorBean {


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
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        StringWriter writer = new StringWriter();
        JsonGenerator generator = Json.createGenerator(writer);
        generator.writeStartObject();
        generator.write("property", "propertyValue");
        generator.writeEnd();
        generator.flush();
        output = writer.toString();
        return "";
    }
}
