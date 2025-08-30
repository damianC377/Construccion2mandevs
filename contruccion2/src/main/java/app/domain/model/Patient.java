package app.domain.model;

import java.sql.Date;

public class Patient {
    private long id;
    private String fullName;
    private Date dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private MedicalRecord medicalRecord;
    private EmergencyContact emergencyContact;
    private HealthInsurance healthInsurance;
    private Invoice invoice;



    // Getters
    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }

    public Invoice getInvoice() {
        return invoice;
    }


    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}