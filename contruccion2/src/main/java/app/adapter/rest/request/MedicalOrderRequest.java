package app.adapter.rest.request;

import java.util.List;

public class MedicalOrderRequest {

    private String orderNumber; // opcional, se puede enviar o generar
    private String patientDocument; // documento del paciente
    private String doctorDocument;  // documento del doctor
    private String orderDate; // Fecha de creación de la orden (yyyy-mm-dd)

    // Lista con los sub-requests (medicamentos, procedimientos, diagnósticos)
    private List<OrderRequest> items;

    // === Getters y Setters ===

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPatientDocument() {
        return patientDocument;
    }

    public void setPatientDocument(String patientDocument) {
        this.patientDocument = patientDocument;
    }

    public String getDoctorDocument() {
        return doctorDocument;
    }

    public void setDoctorDocument(String doctorDocument) {
        this.doctorDocument = doctorDocument;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderRequest> items) {
        this.items = items;
    }
}