package app.adapter.rest.request;

public class DiagnosticTestOrderRequest extends OrderRequest {

    private String diagnosticTestInventoryId;
    private String quantity;
    private String requiresSpecialist;
    private String specialist;

    // === Getters y Setters ===


    public String getDiagnosticTestInventoryId() {
        return diagnosticTestInventoryId;
    }

    public void setDiagnosticTestInventoryId(String diagnosticTestInventoryId) {
        this.diagnosticTestInventoryId = diagnosticTestInventoryId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRequiresSpecialist() {
        return requiresSpecialist;
    }

    public void setRequiresSpecialist(String requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
}