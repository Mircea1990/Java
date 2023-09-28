package jakartaee.examples.jsonp.jsonwriter;

import java.io.StringWriter;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonWriter;

/**
 * A request scoped bean for the JsonWriter example.
 */
@Named @RequestScoped public class JsonWriterBean {

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
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeArray(Json.createArrayBuilder().build());
        output = stringWriter.toString();
        return "";
    }
}
