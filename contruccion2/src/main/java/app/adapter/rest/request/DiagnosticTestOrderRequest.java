package app.adapter.rest.request;

public class DiagnosticTestOrderRequest extends OrderRequest{

    private long diagnosticTestInventoryId; // id del examen diagnóstico
    private int quantity;
    private boolean requiresSpecialist;
    private String specialist;

    // === Getters y Setters ===
    public long getDiagnosticTestInventoryId() {
        return diagnosticTestInventoryId;
    }

    public void setDiagnosticTestInventoryId(long diagnosticTestInventoryId) {
        this.diagnosticTestInventoryId = diagnosticTestInventoryId;
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
