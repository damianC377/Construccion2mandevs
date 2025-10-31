package app.infrastructure.persistence.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber; // identificador único por ítem

    @Column(nullable = false)
    private int itmNumber;

    @Column(nullable = false)
    private double cost;

    // Relación inversa con la orden médica principal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_order_id", nullable = false)
    private MedicalOrderEntity medicalOrder;

    // === Getters y Setters ===
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getItmNumber() {
        return itmNumber;
    }

    public void setItmNumber(int itmNumber) {
        this.itmNumber = itmNumber;
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
