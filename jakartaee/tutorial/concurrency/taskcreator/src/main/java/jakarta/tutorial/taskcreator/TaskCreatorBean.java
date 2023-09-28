package jakarta.tutorial.taskcreator;

import java.io.Serializable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/* Bean for the index.xhtml JSF page */
@Named @SessionScoped public class TaskCreatorBean implements Serializable {

    private static final long serialVersionUID = 7393500655950989708L;
    private static final Logger log = Logger.getLogger("TaskCreatorBean");

    @EJB TaskEJB taskEJB;

    private String taskMessages;
    private String taskType;
    private String taskName;
    private String periodicTask;

    public TaskCreatorBean() {
        taskMessages = "";
        taskType = "IMMEDIATE";
        taskName = "";
        periodicTask = "";
    }

    public String getTaskMessages() {
        taskMessages = taskEJB.getInfoField();
        return taskMessages;
    }

    public void setTaskMessages(String msg) {
        taskMessages = msg;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String t) {
        taskType = t;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String n) {
        taskName = n;
    }

    public String getPeriodicTask() {
        return periodicTask;
    }

    public void setPeriodicTask(String t) {
        periodicTask = t;
    }

    public Set<String> getPeriodicTasks() {
        return taskEJB.getPeriodicTasks();
    }

    /* Executed via an AJAX call in the Submit button */
    public void submitTask() {
        if (taskEJB.getPeriodicTasks().contains(taskName) == false) {
            /* Create a new task object */
            Task task = new Task(taskName, taskType);
            /* Use the managed executor objects to run the task */
            taskEJB.submitTask(task, taskType);
            taskType = "IMMEDIATE";
            taskName = "";
        }
    }

    /* Executed via an AJAX call in the Cancel Task button */
    public void cancelTask() {
        log.log(Level.INFO, "[TaskCreatorBean] Cancelling task {0}", periodicTask);
        taskEJB.cancelPeriodicTask(periodicTask);
    }

    /* Executed via an AJAX call in the Clean Log button */
    public void clearInfoField() {
        taskEJB.clearInfoField();
    }

}
