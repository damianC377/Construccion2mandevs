package app.adapter.rest.response;

import java.sql.Date;
import java.util.List;

public class MedicalOrderResponse {

    private Long orderNumber;
    private String patientName;
    private String doctorName;
    private Date orderDate;
    private List<String> itemsSummary; // Descripciones cortas de las órdenes hijas

    // === Getters y Setters ===
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<String> getItemsSummary() {
        return itemsSummary;
    }

    public void setItemsSummary(List<String> itemsSummary) {
        this.itemsSummary = itemsSummary;
    }
}
