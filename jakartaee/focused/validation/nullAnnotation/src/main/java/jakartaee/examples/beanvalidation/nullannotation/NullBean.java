package jakartaee.examples.beanvalidation.nullannotation;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 * A request scoped bean for the BenValidation @Null example.
 */
@Named @RequestScoped public class NullBean {

    /**
     * Stores the null model.
     */
    private NullModel nullModel = new NullModel();

    /**
     * Get the null model.
     *
     * @return the null model.
     */
    public NullModel getNullModel() {
        return nullModel;
    }

    /**
     * Set the null model.
     *
     * @param nullModel the null model.
     */
    public void setNullModel(NullModel nullModel) {
        this.nullModel = nullModel;
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
