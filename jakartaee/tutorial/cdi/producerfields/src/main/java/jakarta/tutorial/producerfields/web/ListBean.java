package jakarta.tutorial.producerfields.web;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ConversationScoped;
import jakarta.inject.Named;
import jakarta.tutorial.producerfields.ejb.RequestBean;
import jakarta.tutorial.producerfields.entity.ToDo;
import jakarta.validation.constraints.NotNull;

@Named @ConversationScoped public class ListBean implements Serializable {

    private static final long serialVersionUID = 8751711591138727525L;

    @EJB private RequestBean request;
    @NotNull private String inputString;
    private ToDo toDo;
    private List<ToDo> toDos;

    public void createTask() {
        this.toDo = request.createToDo(inputString);
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public ToDo getToDo() {
        return toDo;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

    public List<ToDo> getToDos() {
        return request.getToDos();
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }
}
