package app.adapter.rest.request;

public class OrderRequest {

    private String orderNumber;   // opcional, se genera al guardar
    private int itemNumber;
    private double cost;
    private String medicalOrderId; // ID de la orden médica asociada

    // === Getters y Setters ===
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
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

}
