package jakartaee.examples.faces.inputfile;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;

/**
 * A request scoped bean for the h:inputFile example.
 */
@Named(value = "inputFileBean") @RequestScoped public class InputFileBean {

    /**
     * Stores the part.
     */
    private Part part;

    /**
     * Get the file (part).
     *
     * @return the time.
     */
    public Part getFile() {
        return part;
    }

    /**
     * Set the file.
     *
     * @param part the part.
     */
    public void setFile(Part part) {
        this.part = part;
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
