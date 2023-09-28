package jakartaee.tutorial.dukestutoring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity @XmlRootElement(name = "Guardian") public class Guardian extends Person
        implements Serializable {
    private static final long serialVersionUID = 3237332589550855565L;
    protected boolean active;
    @ManyToMany(mappedBy = "guardians") private List<Student> students;

    public Guardian() {
        this.students = new ArrayList<>();
    }

    /**
     * Get the value of active
     *
     * @return the value of active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Set the value of active
     *
     * @param active new value of active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guardian)) {
            return false;
        }
        Guardian other = (Guardian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(
                other.id))) {
            return false;
        }
        return true;
    }

    @Override public String toString() {
        return "dukestutoring.entity.Guardian[id=" + id + "]";
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
