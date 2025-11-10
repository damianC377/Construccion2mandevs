package app.adapter.rest.request;

public class OrderRequest {

    private String orderNumber;   // opcional, se genera al guardar
    private String itemNumber;
    private String cost;
    private String medicalOrderId; // ID de la orden médica asociada

    // === Getters y Setters ===
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
