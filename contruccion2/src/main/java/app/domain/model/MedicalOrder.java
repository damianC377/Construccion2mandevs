package app.domain.model;

import java.sql.Date;
import java.util.List;

// Orden médica principal que agrupa los diferentes tipos de órdenes: medicamentos,
// procedimientos y ayudas diagnósticas.
public class MedicalOrder {
    private long orderNumber;
    private Patient patient;
    private User doctor;
    private Date orderDate;
    private List<Order> items; // Lista de los subtipos de ordenes

    // Getters
    public long getOrderNumber() {
        return orderNumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<Order> getItems() {
        return items;
    }

    // Setters
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setItems(List<Order> items) {
        this.items = items;
    }


}
