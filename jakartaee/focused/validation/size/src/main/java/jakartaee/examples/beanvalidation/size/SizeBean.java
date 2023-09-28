package jakartaee.examples.beanvalidation.size;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 * A request scoped bean for the BeanValidation @Size example.
 */
@Named @RequestScoped public class SizeBean {

    /**
     * Stores the size.
     */
    private SizeModel size = new SizeModel();

    /**
     * Get the size.
     *
     * @return the text.
     */
    public SizeModel getSize() {
        return size;
    }

    /**
     * Set the size.
     *
     * @param size the size.
     */
    public void setSize(SizeModel size) {
        this.size = size;
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
