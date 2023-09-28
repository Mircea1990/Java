package jakarta.tutorial.producerfields.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity public class ToDo implements Serializable {

    private static final long serialVersionUID = 6449030320444473838L;
    protected String taskText;
    @Temporal(TemporalType.TIMESTAMP) protected Date timeCreated;
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    public ToDo() {
    }

    public ToDo(Long id, String taskText, Date timeCreated) {
        this.id = id;
        this.taskText = taskText;
        this.timeCreated = timeCreated;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    @Override public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override public boolean equals(Object object) {

        if (!(object instanceof ToDo)) {
            return false;
        }
        ToDo other = (ToDo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(
                other.id))) {
            return false;
        }
        return true;
    }

    @Override public String toString() {
        return "entity.ToDo[id=" + id + "]";
    }
}
