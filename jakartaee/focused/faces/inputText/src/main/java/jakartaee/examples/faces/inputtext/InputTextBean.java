package jakartaee.examples.faces.inputtext;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * A request scoped bean for the h:inputText example.
 */
@Named @RequestScoped public class InputTextBean {

    /**
     * Stores the text.
     */
    private String text;

    /**
     * Get the text.
     *
     * @return the text.
     */
    public String getText() {
        return text;
    }

    /**
     * Set the text.
     *
     * @param text the text.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        return "";
    }
}
