package app.domain.model;

public class DiagnosticTestOrder extends Order {
    private DiagnosticTestInventory diagnosticTestInventory;
    private int quantity;
    private boolean requiresSpecialist;
    private String specialist;
    

    // Getters

    public DiagnosticTestInventory getDiagnosticTestInventory() {
        return diagnosticTestInventory;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public String specialist () {
        return specialist;
    }


    // Setters

    public void setDiagnosticTestInventory(DiagnosticTestInventory diagnosticTestInventory) {
        this.diagnosticTestInventory = diagnosticTestInventory;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

}
