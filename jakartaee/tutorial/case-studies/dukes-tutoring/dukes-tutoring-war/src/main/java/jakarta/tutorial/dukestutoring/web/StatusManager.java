package jakarta.tutorial.dukestutoring.web;

import java.util.Locale;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.tutorial.dukestutoring.util.StatusType;


@Named @RequestScoped public class StatusManager {

    private final FacesContext ctx = FacesContext.getCurrentInstance();
    private final Locale locale;

    /**
     * Creates a new instance of StatusManager
     */
    public StatusManager() {
        locale = ctx.getViewRoot().getLocale();
    }

    public String getLocalizedStatus(StatusType status) {
        return status.toString(locale);
    }

}
