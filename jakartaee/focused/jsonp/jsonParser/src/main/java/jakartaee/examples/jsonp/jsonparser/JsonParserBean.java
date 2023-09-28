package jakartaee.examples.jsonp.jsonparser;

import java.io.StringReader;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.json.Json;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

/**
 * A request scoped bean for the JsonParser example.
 */
@Named @RequestScoped public class JsonParserBean {

    /**
     * Stores the input.
     */
    private String input;

    /**
     * Stores the output.
     */
    private String output;

    /**
     * Get the input.
     *
     * @return the input.
     */
    public String getInput() {
        return input;
    }

    /**
     * Set the input.
     *
     * @param input the input.
     */
    public void setInput(String input) {
        this.input = input;
    }

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
        JsonParser parser = Json.createParser(new StringReader(input));
        StringBuilder builder = new StringBuilder();
        while (parser.hasNext()) {
            Event event = parser.next();
            builder.append(event.toString()).append("\n");
        }
        output = builder.toString();
        return "";
    }
}
