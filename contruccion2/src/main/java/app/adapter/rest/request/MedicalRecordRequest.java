package app.adapter.rest.request;

import java.util.List;

public class MedicalRecordRequest {
    private String patientDocument;
    private String doctorDocument;
    private String orderDate;
    private String consultationReason;
    private String symptoms;
    private String diagnosis;
    private List<MedicalOrderRequest> orders;

    public String getPatientDocument() { return patientDocument; }
    public void setPatientDocument(String patientDocument) { this.patientDocument = patientDocument; }

    public String getDoctorDocument() { return doctorDocument; }
    public void setDoctorDocument(String doctorDocument) { this.doctorDocument = doctorDocument; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public String getConsultationReason() { return consultationReason; }
    public void setConsultationReason(String consultationReason) { this.consultationReason = consultationReason; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public List<MedicalOrderRequest> getOrders() { return orders; }
    public void setOrders(List<MedicalOrderRequest> orders) { this.orders = orders; }
}
