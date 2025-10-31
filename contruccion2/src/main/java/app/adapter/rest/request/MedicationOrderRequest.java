package app.adapter.rest.request;

public class MedicationOrderRequest extends OrderRequest{

    private long medicationId; // id del medicamento
    private String dosage;
    private String treatmentDuration;

    // === Getters y Setters ===
    public long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(long medicationId) {
        this.medicationId = medicationId;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }

    public void setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }
}
