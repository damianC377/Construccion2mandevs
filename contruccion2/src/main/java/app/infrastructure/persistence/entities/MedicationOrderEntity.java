package app.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medication_orders")
@PrimaryKeyJoinColumn(name = "order_id")
public class MedicationOrderEntity extends OrderEntity{

    // Relación con el inventario de medicamentos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medication_id", nullable = false)
    private MedicationInventoryEntity medication;

    @Column(nullable = false)
    private String dosage;

    @Column(nullable = false)
    private String treatmentDuration;

    // === Getters y Setters ===
    public MedicationInventoryEntity getMedication() {
        return medication;
    }

    public void setMedication(MedicationInventoryEntity medication) {
        this.medication = medication;
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
