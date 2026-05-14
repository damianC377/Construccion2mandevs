package app.domain.model;

import java.sql.Date;

public class Invoice {
    private long id;
    private Patient patient;
    private User doctor;
    private HealthInsurance insurance;
    private String policyNumber;
    private int policyValidityDays;
    private Date policyEndDate;
    private MedicalOrder medicalOrder;

    // Getters
    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public HealthInsurance getInsurance() {
        return insurance;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public int getPolicyValidityDays() {
        return policyValidityDays;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public MedicalOrder getMedicalOrder() {
        return medicalOrder;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public void setInsurance(HealthInsurance insurance) {
        this.insurance = insurance;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setPolicyValidityDays(int policyValidityDays) {
        this.policyValidityDays = policyValidityDays;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public void setMedicalOrder(MedicalOrder medicalOrder) {
        this.medicalOrder = medicalOrder;
    }
}
