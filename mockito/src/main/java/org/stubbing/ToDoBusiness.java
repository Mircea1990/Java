package org.stubbing;

import java.util.ArrayList;
import java.util.List;

// ToDoBusiness is a SUT (system under test)
public class ToDoBusiness {

    // ToDoService is a Dependency (as ToDoBusiness is dependent on it)
    public ToDoService doService;

    public ToDoBusiness(ToDoService doService) {
        this.doService = doService;
    }

    public List<String> getTodosSpring(String user) {

        List<String> retrievedToDos = new ArrayList<>();
        List<String> toDos = doService.getTodos(user);

        for (String toDo : toDos) {
            if (toDo.contains("Spring")) {
                retrievedToDos.add(toDo);
            }
        }
        return retrievedToDos;
    }
}
