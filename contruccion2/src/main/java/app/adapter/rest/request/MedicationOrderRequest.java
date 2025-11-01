package app.adapter.rest.request;

public class MedicationOrderRequest extends OrderRequest{

    private String dosage;
    private String treatmentDuration;

    // === Getters y Setters ===
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
