package app.domain.model;

import java.sql.Date;

public class HealthInsurance {
    private String companyName;
    private String policyNumber;
    private boolean active;    // true = active, false = inactive
    private Date endDate;

    // Getters
    public String getCompanyName() {
        return companyName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public boolean isActive() {
        return active;
    }

    public Date getEndDate() {
        return endDate;
    }

    // Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
