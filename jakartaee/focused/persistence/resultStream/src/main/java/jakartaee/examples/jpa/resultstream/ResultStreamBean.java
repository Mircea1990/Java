package jakartaee.examples.jpa.resultstream;

import java.io.Serializable;
import java.util.stream.Collectors;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean for the resultStream example.
 */
@Named("resultStreamBean") @RequestScoped public class ResultStreamBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private ResultStreamEjb ejb;

    /**
     * Get all the rows.
     *
     * @return all the rows.
     */
    public String getOutput() {
        String result = ejb.getRows().map(r -> r.getId().toString()).collect(
                Collectors.joining(","));
        return result;
    }
}
