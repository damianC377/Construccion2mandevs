package app.domain.model;

public class MedicationOrder extends Order {

	private MedicationInventory medication;
	private String dosage;
	private String treatmentDuration;

	public MedicationInventory getMedication() {
		return medication;
	}

	public String getDosage() {
		return dosage;
	}

	public String getTreatmentDuration() {
		return treatmentDuration;
	}

	// Setters

	public void setMedication(MedicationInventory medication) {
		this.medication = medication;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public void setTreatmentDuration(String treatmentDuration) {
		this.treatmentDuration = treatmentDuration;
	}

}
