package app.domain.model;

public class DiagnosticTestOrder extends Order {
    private DiagnosticTestInventory diagnosticTestInventory;
    private int quantity;
    private boolean requiresSpecialist;
    private Specialist Specialist;
    

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

    public Specialist getSpecialist() {
        return Specialist;
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

    public void setSpecialist(Specialist specialist) {
        Specialist = specialist;
    }

}
