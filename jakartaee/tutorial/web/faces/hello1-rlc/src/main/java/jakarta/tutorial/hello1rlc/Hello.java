package jakarta.tutorial.hello1rlc;

import jakarta.enterprise.inject.Model;

@Model public class Hello {

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

