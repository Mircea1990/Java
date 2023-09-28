package jakartaee.examples.jsonb.fromObjectToJson;

import java.util.ArrayList;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.JsonbBuilder;

/**
 * A request scoped bean for using with the Object to JSON example.
 */
@Named(value = "objectToJsonBean") @RequestScoped public class ObjectToJsonBean {

    /**
     * Stores the json.
     */
    private String json;

    /**
     * Stores the string.
     */
    private String string;

    /**
     * Get the JSON.
     *
     * @return the JSON.
     */
    public String getJson() {
        return json;
    }

    /**
     * Set the JSON.
     *
     * @param json the json.
     */
    public void setJson(String json) {
        this.json = json;
    }

    /**
     * Get the string.
     *
     * @return the string.
     */
    public String getString() {
        return string;
    }

    /**
     * Set the string.
     *
     * @param string the string.
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        JsonbBuilder builder = JsonbBuilder.newBuilder();
        ArrayList list = new ArrayList<>();
        list.add(string);
        json = builder.build().toJson(list);
        return "";
    }
}
