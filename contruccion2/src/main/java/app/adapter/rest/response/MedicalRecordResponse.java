package app.adapter.rest.response;

import java.sql.Date;
import java.util.List;

public class MedicalRecordResponse {
    private long id;
    private long patientDocument;
    private Date orderDate;
    private String doctorDocument;
    private String consultationReason;
    private String symptoms;
    private String diagnosis;
    private List<MedicalOrderResponse> orders;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getPatientDocument() { return patientDocument; }
    public void setPatientDocument(long patientDocument) { this.patientDocument = patientDocument; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getDoctorDocument() { return doctorDocument; }
    public void setDoctorDocument(String doctorDocument) { this.doctorDocument = doctorDocument; }

    public String getConsultationReason() { return consultationReason; }
    public void setConsultationReason(String consultationReason) { this.consultationReason = consultationReason; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public List<MedicalOrderResponse> getOrders() { return orders; }
    public void setOrders(List<MedicalOrderResponse> orders) { this.orders = orders; }
}
