package app.infrastructure.persistence.entities;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "health_insurances")
public class HealthInsuranceEntity {

    // ID único generado automáticamente para cada seguro médico.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;

    @Column(name = "policy_number", nullable = false, length = 50)
    private long policyNumber;

    @Column(nullable = false)
    private boolean active;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(long policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
