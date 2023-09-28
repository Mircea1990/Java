package jakarta.tutorial.checkoutmodule;

import java.io.Serializable;

import jakarta.faces.flow.FlowScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

/**
 * Backing bean for JoinFlow.
 */
@Named @FlowScoped("joinFlow") public class JoinFlowBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final SelectItem[] newsletterItems = {new SelectItem("Duke's Quarterly"),
            new SelectItem("Innovator's Almanac"), new SelectItem(
            "Duke's Diet and Exercise Journal"), new SelectItem("Random Ramblings")};
    private boolean fanClub;
    private String[] newsletters;

    public JoinFlowBean() {
        this.newsletters = new String[0];
    }

    public String getReturnValue() {
        return "/exithome";
    }

    public boolean isFanClub() {
        return fanClub;
    }

    public void setFanClub(boolean fanClub) {
        this.fanClub = fanClub;
    }

    public String[] getNewsletters() {
        return newsletters;
    }

    public void setNewsletters(String[] newsletters) {
        this.newsletters = newsletters;
    }

    public SelectItem[] getNewsletterItems() {
        return newsletterItems;
    }

}
