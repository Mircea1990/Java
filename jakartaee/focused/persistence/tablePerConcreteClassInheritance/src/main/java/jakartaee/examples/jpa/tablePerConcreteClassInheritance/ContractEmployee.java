package jakartaee.examples.jpa.tablePerConcreteClassInheritance;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity @Table(name = "CONTRACT_EMPLOYEE") @AttributeOverrides(
        {@AttributeOverride(name = "name", column = @Column(name = "FULLNAME")),
                @AttributeOverride(name = "startDate", column = @Column(name = "SDATE"))})
public class ContractEmployee extends Employee {

    @Column(name = "DAILY_RATE") private Integer dailyRate;
    private Integer term;

    public Integer getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Integer dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

}
