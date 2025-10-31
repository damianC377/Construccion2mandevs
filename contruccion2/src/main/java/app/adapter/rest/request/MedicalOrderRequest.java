package app.adapter.rest.request;

import java.sql.Date;
import java.util.List;

public class MedicalOrderRequest {

    private Long patientId; // ID del paciente
    private Long doctorId;  // ID del doctor
    private Date orderDate; // Fecha de creación de la orden

    // Lista con los IDs de las subórdenes (medicamentos, procedimientos, diagnósticos)
    private List<Long> itemIds;

    // === Getters y Setters ===
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
