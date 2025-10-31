package app.adapter.rest.response;

public class DiagnosticTestOrderResponse extends OrderResponse{
    private Long diagnosticTestInventoryId;
    private String diagnosticTestName;
    private int quantity;
    private boolean requiresSpecialist;
    private String specialist;
    private double cost;

    // Getters y Setters
    public Long getDiagnosticTestInventoryId() {
        return diagnosticTestInventoryId;
    }

    public void setDiagnosticTestInventoryId(Long diagnosticTestInventoryId) {
        this.diagnosticTestInventoryId = diagnosticTestInventoryId;
    }

    public String getDiagnosticTestName() {
        return diagnosticTestName;
    }

    public void setDiagnosticTestName(String diagnosticTestName) {
        this.diagnosticTestName = diagnosticTestName;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
