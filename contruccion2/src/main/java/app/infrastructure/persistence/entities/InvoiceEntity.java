package app.infrastructure.persistence.entities;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    // ID único generado automáticamente para cada factura.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Relación con el paciente (muchas facturas pueden pertenecer a un paciente)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    // Relación con el médico tratante (usuario con rol de doctor)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    // Relación con el seguro médico del paciente
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "insurance_id", nullable = true)
    private HealthInsuranceEntity insurance;

    @Column(name = "policy_number", length = 50)
    private String policyNumber;

    @Column(name = "policy_validity_days")
    private int policyValidityDays;

    @Column(name = "policy_end_date")
    private Date policyEndDate;

    // Relación con la orden médica asociada
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medical_order_id", nullable = false)
    private MedicalOrderEntity medicalOrder;

    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public UserEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(UserEntity doctor) {
        this.doctor = doctor;
    }

    public HealthInsuranceEntity getInsurance() {
        return insurance;
    }

    public void setInsurance(HealthInsuranceEntity insurance) {
        this.insurance = insurance;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getPolicyValidityDays() {
        return policyValidityDays;
    }

    public void setPolicyValidityDays(int policyValidityDays) {
        this.policyValidityDays = policyValidityDays;
    }

    public Date getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(Date policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public MedicalOrderEntity getMedicalOrder() {
        return medicalOrder;
    }

    public void setMedicalOrder(MedicalOrderEntity medicalOrder) {
        this.medicalOrder = medicalOrder;
    }
}

