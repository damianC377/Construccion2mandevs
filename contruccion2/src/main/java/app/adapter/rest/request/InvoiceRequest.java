package app.adapter.rest.request;

public class InvoiceRequest {
    private String patientDocument;
    private String doctorDocument;
    private String healthInsurancePolicyNumber;
    private String policyNumber;
    private String policyValidityDays;
    private String policyEndDate;
    private String medicalOrderId;


    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getDoctorDocument() {
        return doctorDocument;
    }

    public void setDoctorDocument(String doctorDocument) {
        this.doctorDocument = doctorDocument;
    }

    public String getHealthInsurancePolicyNumber() {
        return healthInsurancePolicyNumber;
    }

    public void setHealthInsurancePolicyNumber(String healthInsurancePolicyNumber) {
        this.healthInsurancePolicyNumber = healthInsurancePolicyNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyValidityDays() {
        return policyValidityDays;
    }

    public void setPolicyValidityDays(String policyValidityDays) {
        this.policyValidityDays = policyValidityDays;
    }

    public String getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public String getMedicalOrderId() {
        return medicalOrderId;
    }

    public void setMedicalOrderId(String medicalOrderId) {
        this.medicalOrderId = medicalOrderId;
    }


}


