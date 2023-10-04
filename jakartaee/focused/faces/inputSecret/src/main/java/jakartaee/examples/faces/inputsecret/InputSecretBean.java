package jakartaee.examples.faces.inputsecret;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 * A request scoped bean for the h:inputSecret example.
 */
@Named @RequestScoped public class InputSecretBean {

    /**
     * Stores the part.
     */
    private String secret;

    /**
     * Get the secret.
     *
     * @return the secret.
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Set the secret.
     *
     * @param secret the secret.
     */
    public void setSecret(String secret) {
        this.secret = secret;
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
