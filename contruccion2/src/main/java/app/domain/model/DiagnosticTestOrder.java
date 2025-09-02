package app.domain.model;

public class DiagnosticTestOrder extends Order {
    private long orderNumber;
    private DiagnosticTestInventory diagnosticTestInventory;
    private int quantity;
    private double cost;
    private boolean requiresSpecialist;
    private Specialist Specialist;
    private int itemNumber;

    // Getters
    public long getOrderNumber() {
        return orderNumber;
    }

    public DiagnosticTestInventory getDiagnosticTestInventory() {
        return diagnosticTestInventory;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public Specialist getSpecialist() {
        return Specialist;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    // Setters
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setDiagnosticTestInventory(DiagnosticTestInventory diagnosticTestInventory) {
        this.diagnosticTestInventory = diagnosticTestInventory;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public void setSpecialist(Specialist specialist) {
        Specialist = specialist;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}
