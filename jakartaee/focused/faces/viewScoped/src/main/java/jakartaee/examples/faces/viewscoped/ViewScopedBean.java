package jakartaee.examples.faces.viewscoped;

import java.io.Serializable;
import java.util.Date;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

/**
 * A view scoped bean.
 */
@Named(value = "viewScopedBean") @ViewScoped public class ViewScopedBean implements Serializable {

    /**
     * Stores the time.
     */
    private String time;

    /**
     * Different view.
     *
     * @return "different"
     */
    public String differentView() {
        return "different";
    }

    /**
     * Index view.
     *
     * @return "index"
     */
    public String indexView() {
        return "index";
    }

    /**
     * Initialize the bean.
     */
    @PostConstruct public void initialize() {
        time = new Date().toString() + " - " + System.nanoTime();
    }

    /**
     * Get the time.
     *
     * @return the time.
     */
    public String getTime() {
        return time;
    }

    /**
     * Same view.
     *
     * @return ""
     */
    public String sameView() {
        return "";
    }
}
