package jakartaee.examples.beanvalidation.notnull;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 * A request scoped bean for the BeanValidation @NotNull example.
 */
@Named @RequestScoped public class NotNullBean {

    /**
     * Stores the not null model.
     */
    private NotNullModel notNull = new NotNullModel();

    /**
     * Get the not null model.
     *
     * @return the not null model.
     */
    public NotNullModel getNotNull() {
        return notNull;
    }

    /**
     * Set the not null model.
     *
     * @param notNull the not null model.
     */
    public void setNotNull(NotNullModel notNull) {
        this.notNull = notNull;
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
