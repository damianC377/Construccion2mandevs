package app.domain.model;

import java.sql.Date;

public class MedicalOrder {
    private long id;
    private Patient patient;
    private User doctor;
    private String type; // medication / exam / procedure
    private String detail;
    private String dose;
    private Date date;
    private Boolean status;

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

    public String getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }

    public String getDose() {
        return dose;
    }

    public Date getDate() {
        return date;
    }

    public boolean getStatus() {
        return status;
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

    public void setType(String type) {
        this.type = type;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
