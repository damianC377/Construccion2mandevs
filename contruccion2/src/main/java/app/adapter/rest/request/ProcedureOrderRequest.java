package app.adapter.rest.request;

public class ProcedureOrderRequest extends OrderRequest {

    private String procedureId; // id del procedimiento
    private String quantity;
    private String frequency;
    private String requiresSpecialist;
    private String specialist;

    // === Getters y Setters ===

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
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