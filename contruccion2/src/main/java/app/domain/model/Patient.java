package app.domain.model;

public class Patient extends Person {
    private long patientId;
    private String emergencyContact;
    private MedicalRecord medicalRecord ;

    // Getters
    public long getPatientId() {
        return patientId;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    // Setters
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
