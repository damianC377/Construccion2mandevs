package app.domain.model;

public class ProcedureOrder {
    private long orderNumber;
    private ProcedureInventory procedure;
    private int quantity;
    private String frequency;
    private double cost;
    private boolean requiresSpecialist;
    private Specialist specialist;
    private int itemNumber;

    // Getters
    public long getOrderNumber() {
        return orderNumber;
    }

    public ProcedureInventory getProcedure() {
        return procedure;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public double getCost() {
        return cost;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public int getItemNumber() {
        return itemNumber;
    }


    // Setters
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setProcedure(ProcedureInventory procedure) {
        this.procedure = procedure;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }
}
