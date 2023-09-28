package jakartaee.examples.jsonp.jsonreader;

import java.io.StringReader;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;

/**
 * A request scoped bean for the JsonReader example.
 */
@Named @RequestScoped public class JsonReaderBean {

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
        JsonReader jsonReader = Json.createReader(new StringReader("[]"));
        JsonArray array = jsonReader.readArray();
        jsonReader.close();
        output = array.toString();
        return "";
    }
}
