package app.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "procedure_orders")
@PrimaryKeyJoinColumn(name = "order_id")
public class ProcedureOrderEntity extends OrderEntity{

    // Relación con el inventario de procedimientos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedure_id", nullable = false)
    private ProcedureInventoryEntity procedure;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String frequency;

    @Column(nullable = false)
    private boolean requiresSpecialist;

    @Column(nullable = true)
    private String specialist;

    // === Getters y Setters ===
    public ProcedureInventoryEntity getProcedure() {
        return procedure;
    }

    public void setProcedure(ProcedureInventoryEntity procedure) {
        this.procedure = procedure;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
}
