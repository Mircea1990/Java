package jakartaee.examples.jpa.tablePerConcreteClassInheritance;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass public abstract class CompanyEmployee extends Employee {

    private Integer vacation;
    @ManyToOne private ContractEmployee manager;

    public Integer getVacation() {
        return vacation;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

    public ContractEmployee getManager() {
        return manager;
    }

    public void setManager(ContractEmployee manager) {
        this.manager = manager;
    }

}
