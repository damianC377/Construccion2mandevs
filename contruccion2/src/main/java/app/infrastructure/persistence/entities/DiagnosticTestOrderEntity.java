package app.infrastructure.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_test_orders")
@PrimaryKeyJoinColumn(name = "order_number")
public class DiagnosticTestOrderEntity extends OrderEntity {

    // Relación con el inventario de pruebas diagnósticas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnostic_test_inventory_id", nullable = false)
    private DiagnosticTestInventoryEntity diagnosticTestInventory;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private boolean requiresSpecialist;

    @Column(length = 100)
    private String specialist;

    // === Getters y Setters ===
    public DiagnosticTestInventoryEntity getDiagnosticTestInventory() {
        return diagnosticTestInventory;
    }

    public void setDiagnosticTestInventory(DiagnosticTestInventoryEntity diagnosticTestInventory) {
        this.diagnosticTestInventory = diagnosticTestInventory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
