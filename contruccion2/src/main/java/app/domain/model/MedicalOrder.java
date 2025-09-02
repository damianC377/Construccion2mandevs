package app.domain.model;

import java.sql.Date;
import java.util.List;

//Orden medica que contiene a todas las demas (medicamento, procedimiento,
//ayudas diagnosticas).
public class MedicalOrder {
    private long orderNumber;
    private Patient patient;
    private User doctor;
    private Date orderDate;
    private List<Order> items;

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

   
}
