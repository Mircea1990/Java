package jakartaee.examples.jpa.tablePerConcreteClassInheritance;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity @Table(name = "PARTTIME_EMPLOYEE")
@AssociationOverride(name = "manager", joinColumns = @JoinColumn(name = "MGR"))
public class PartTimeEmployee extends CompanyEmployee {

    @Column(name = "HOURLY_RATE") private Float hourlyRate;

    public Float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

}
