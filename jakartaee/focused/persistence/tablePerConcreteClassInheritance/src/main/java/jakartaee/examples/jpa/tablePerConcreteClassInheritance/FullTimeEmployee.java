package jakartaee.examples.jpa.tablePerConcreteClassInheritance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity @Table(name = "FULLTIME_EMPLOYEE") public class FullTimeEmployee extends CompanyEmployee {

    private Long salary;
    @Column(name = "PENSION") private Long pensionContribution;

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getPensionContribution() {
        return pensionContribution;
    }

    public void setPensionContribution(Long pensionContribution) {
        this.pensionContribution = pensionContribution;
    }

}
