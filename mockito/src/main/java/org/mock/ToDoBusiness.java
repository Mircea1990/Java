package org.mock;

import java.util.ArrayList;
import java.util.List;

// ToDoBusiness is a SUT (system under test)
public class ToDoBusiness {

    // ToDoService is a Dependency (as ToDoBusiness is dependent on it)
    public ToDoService doService;

    public ToDoBusiness(ToDoService doService) {
        this.doService = doService;
    }

    public List<String> getTodosForHibernate(String user) {

        List<String> hibernateList = new ArrayList<>();
        List<String> combinedList = doService.getTodos(user);

        for (String toDo : combinedList) {
            if (toDo.contains("Hibernate")) {
                hibernateList.add(toDo);
            }
        }

        return hibernateList;
    }

    public void deleteTodosNotRelatedToHibernate(String user) {

        List<String> combinedList = doService.getTodos(user);

        for (String toDos : combinedList) {
            if (!toDos.contains("Hibernate")) {
                doService.deleteTodos(toDos);
            }
        }
    }
}
