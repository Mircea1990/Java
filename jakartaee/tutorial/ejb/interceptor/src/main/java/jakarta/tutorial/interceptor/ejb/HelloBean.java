package jakarta.tutorial.interceptor.ejb;

import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.interceptor.Interceptors;


@Stateless @Named public class HelloBean {

    protected String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    @Interceptors(HelloInterceptor.class) public void setName(String name) {
        this.name = name;
    }

}
