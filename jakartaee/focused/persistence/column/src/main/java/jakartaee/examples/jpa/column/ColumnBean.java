package jakartaee.examples.jpa.column;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

/**
 * The bean used to demonstrate usage of @Column.
 */
@Named("columnBean") @RequestScoped public class ColumnBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private ColumnEjb ejb;

    /**
     * Get the list of rows (instances of ColumnRow).
     *
     * @return the list of rows.
     */
    public List<ColumnRow> getRows() {
        return ejb.getRows();
    }
}
