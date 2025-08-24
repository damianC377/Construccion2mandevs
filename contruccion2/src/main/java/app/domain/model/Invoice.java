package app.domain.model;

import java.sql.Date;

public class Invoice {
    private long id;
    private Patient patient;
    private MedicalOrder order;
    private String productService; // service or product
    private int quantity;
    private double value;
    private Date date;

    // Getters
    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public MedicalOrder getOrder() {
        return order;
    }

    public String getProductService() {
        return productService;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setOrder(MedicalOrder order) {
        this.order = order;
    }

    public void setProductService(String productService) {
        this.productService = productService;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
