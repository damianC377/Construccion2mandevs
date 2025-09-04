package app.domain.model;

public class ProcedureOrder extends Order {
    private ProcedureInventory procedure;
    private int quantity;
    private String frequency;
    private boolean requiresSpecialist;
    private Specialist specialist;
    
    // Getters
    
    public ProcedureInventory getProcedure() {
        return procedure;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFrequency() {
        return frequency;
    }


    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public Specialist getSpecialist() {
        return specialist;
    }


    // Setters


    public void setProcedure(ProcedureInventory procedure) {
        this.procedure = procedure;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }


    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

}
