package jakarta.tutorial.dukestutoring.events;

import java.io.Serializable;

import jakartaee.tutorial.dukestutoring.entity.Student;


public class StatusEvent implements Serializable {

    private Student student;

    public StatusEvent() {
    }

    public StatusEvent(Student s) {
        student = s;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

}
