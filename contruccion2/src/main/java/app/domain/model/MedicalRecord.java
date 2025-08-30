package app.domain.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private long id;
    private Patient patient;
    private Date orderDate;
    private User doctor;
    private String consultationReason;
    private String symptoms;
    private String diagnosis;
    private List<MedicalOrder> orders;

    // Getters

    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public User getDoctor() {
        return doctor;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public List<MedicalOrder> getOrders() {
        return orders;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setOrders(List<MedicalOrder> orders) {
        this.orders = orders;
    }
}
