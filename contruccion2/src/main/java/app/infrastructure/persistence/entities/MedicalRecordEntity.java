package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "medical_records")
public class MedicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Date orderDate;
    private Long doctorId;
    private String consultationReason;
    private String symptoms;
    private String diagnosis;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }
    public String getConsultationReason() { return consultationReason; }
    public void setConsultationReason(String consultationReason) { this.consultationReason = consultationReason; }
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}
