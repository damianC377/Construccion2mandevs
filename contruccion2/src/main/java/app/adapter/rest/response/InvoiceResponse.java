package app.adapter.rest.response;

import app.domain.model.User;

import java.sql.Date;

public class InvoiceResponse {
    private long id;
    private long patientDocument;
    private User doctor;
    private long healthInsurancePolicyNumber;
    private String policyNumber;
    private int policyValidityDays;
    private Date policyEndDate;
    private long medicalOrderId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(long patientDocument) {
        this.patientDocument = patientDocument;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public long getHealthInsurancePolicyNumber() {
        return healthInsurancePolicyNumber;
    }

    public void setHealthInsurancePolicyNumber(long healthInsurancePolicyNumber) {
        this.healthInsurancePolicyNumber = healthInsurancePolicyNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getPolicyValidityDays() {
        return policyValidityDays;
    }

    public void setPolicyValidityDays(int policyValidityDays) {
        this.policyValidityDays = policyValidityDays;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public long getMedicalOrderId() {
        return medicalOrderId;
    }

    public void setMedicalOrderId(long medicalOrderId) {
        this.medicalOrderId = medicalOrderId;
    }
}
