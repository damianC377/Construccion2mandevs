package app.domain.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private long id;
    private Patient patient;
    private User doctor;
    private Date date;
    private String consultationReason;
    private String symptoms;
    private String diagnosis;
    private String procedure;
    private MedicalOrder Order;
    private String notes;

    // Getters
    public long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
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

    public String getProcedure() {
        return procedure;
    }

    public MedicalOrder getOrder() {
        return Order;
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public void setOrder(MedicalOrder order) {
        Order = order;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
