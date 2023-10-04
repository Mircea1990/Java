package jakartaee.examples.jsonb.fromJsonToObject;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.json.bind.JsonbBuilder;

import java.util.List;

/**
 * A request scoped bean for using with the JSON to Object example.
 */
@Named(value = "jsonToObjectBean") @RequestScoped public class JsonToObjectBean {

    /**
     * Stores the JSON.
     */
    private String json;

    /**
     * Stores the list.
     */
    private List list;

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
     * Get the list.
     *
     * @return the list.
     */
    public List getList() {
        return list;
    }

    /**
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        JsonbBuilder builder = JsonbBuilder.newBuilder();
        list = builder.build().fromJson("[" + json + "]", List.class);
        return "";
    }
}
