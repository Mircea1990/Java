package jakarta.tutorial.ajaxguessnumber;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named @RequestScoped public class UserNumberBean implements Serializable {

    private static final long serialVersionUID = 5377607515424187221L;
    @Inject DukesNumberBean dukesNumberBean;
    String response = null;
    private Integer userNumber = null;

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer user_number) {
        userNumber = user_number;
    }

    public String getResponse() {
        if ((userNumber != null) && (userNumber.compareTo(dukesNumberBean.getRandomInt()) == 0)) {
            return "Yay! You got it!";
        }
        if (userNumber == null) {
            return null;
        } else {
            return "Sorry, " + userNumber + " is incorrect.";
        }
    }
}
