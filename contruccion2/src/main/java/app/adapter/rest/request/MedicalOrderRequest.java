package app.adapter.rest.request;

import java.sql.Date;
import java.util.List;

public class MedicalOrderRequest {

    private String patientId; // ID del paciente
    private String doctorId;  // ID del doctor
    private String orderDate; // Fecha de creación de la orden

    // Lista con los IDs de las subórdenes (medicamentos, procedimientos, diagnósticos)
    private List<Long> itemIds;

    // === Getters y Setters ===

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}