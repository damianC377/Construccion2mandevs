package app.adapter.rest.request;

public class OrderRequest {

    private Long orderNumber;   // opcional, se genera al guardar
    private int itemNumber;
    private double cost;
    private Long medicalOrderId; // ID de la orden médica asociada

    // === Getters y Setters ===
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Long getMedicalOrderId() {
        return medicalOrderId;
    }

    public void setMedicalOrderId(Long medicalOrderId) {
        this.medicalOrderId = medicalOrderId;
    }
}
