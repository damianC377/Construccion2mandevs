package app.infrastructure.persistence.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemNumber; // identificador único por ítem

    @Column(nullable = false)
    private double cost;

    // Relación inversa con la orden médica principal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_order_id", nullable = false)
    private MedicalOrderEntity medicalOrder;

    // === Getters y Setters ===
    public Long getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public MedicalOrderEntity getMedicalOrder() {
        return medicalOrder;
    }

    public void setMedicalOrder(MedicalOrderEntity medicalOrder) {
        this.medicalOrder = medicalOrder;
    }
}
