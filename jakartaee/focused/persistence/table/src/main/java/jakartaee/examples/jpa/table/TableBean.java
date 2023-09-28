package jakartaee.examples.jpa.table;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean used to demonstrate usage of @Table.
 */
@Named("tableBean") @RequestScoped public class TableBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private TableEjb ejb;

    /**
     * Get the list of rows (instances of TableRow).
     *
     * @return the list of rows.
     */
    public List<TableRow> getRows() {
        return ejb.getRows();
    }
}
