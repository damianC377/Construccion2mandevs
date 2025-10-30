package app.adapter.rest.request;

public class PatientRequest {
    private String document;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private String medicalRecordId;
    private String emergencyContactDocument;
    private String healthInsurancePolicyNumber;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(String medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getEmergencyContactDocument() {
        return emergencyContactDocument;
    }

    public void setEmergencyContactDocument(String emergencyContactDocument) {
        this.emergencyContactDocument = emergencyContactDocument;
    }

    public String getHealthInsurancePolicyNumber() {
        return healthInsurancePolicyNumber;
    }

    public void setHealthInsurancePolicyNumber(String healthInsurancePolicyNumber) {
        this.healthInsurancePolicyNumber = healthInsurancePolicyNumber;
    }


}
