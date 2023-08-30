package org.stubbing;

import java.util.Arrays;
import java.util.List;

//stub class
public class ToDoServiceStub implements ToDoService {

    public List<String> getTodos(String user) {

        return Arrays.asList(" Use Core Java ", " Use Spring Core ", " Use Hibernate ", " Use Spring MVC ");
    }
}
