package app.adapter.rest.response;

import java.util.Date;

public class PatientResponse {
    private long id;
    private long document;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private long medicalRecordId;
    private long emergencyContactDocument;
    private long healthInsurancePolicyNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public long getEmergencyContactDocument() {
        return emergencyContactDocument;
    }

    public void setEmergencyContactDocument(long emergencyContactDocument) {
        this.emergencyContactDocument = emergencyContactDocument;
    }

    public long getHealthInsurancePolicyNumber() {
        return healthInsurancePolicyNumber;
    }

    public void setHealthInsurancePolicyNumber(long healthInsurancePolicyNumber) {
        this.healthInsurancePolicyNumber = healthInsurancePolicyNumber;
    }
}
