package jakarta.tutorial.hello1_formauth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named @RequestScoped public class Hello {

    private String name;

    public Hello() {
    }

    public String getName() {
        return name;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }
}
