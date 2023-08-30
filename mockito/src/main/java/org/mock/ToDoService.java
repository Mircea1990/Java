package org.mock;

import java.util.List;

public interface ToDoService {
    List<String> getTodos(String user);

    void deleteTodos(String doString);
}
