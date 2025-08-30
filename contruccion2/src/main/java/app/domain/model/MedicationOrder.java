package app.domain.model;

public class MedicationOrder {
    private long orderNumber;
    private MedicationInventory medication;
    private String dosage;
    private String treatmentDuration;
    private int itemNumber;
    private double cost;

    // Getters
    public long getOrderNumber() {
        return orderNumber;
    }

    public MedicationInventory getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public double getCost() {
        return cost;
    }

    // Setters
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setMedication(MedicationInventory medication) {
        this.medication = medication;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
