package app.infrastructure.persistence.entities;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "medical_orders")
public class MedicalOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient; // Paciente asociado

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor; // Doctor que generó la orden

    @Column(nullable = false)
    private Date orderDate;

    // No se eliminan ítems automáticamente si se borra la orden
    @OneToMany(mappedBy = "medicalOrder", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<OrderEntity> items; // Subórdenes: medicamentos, exámenes, etc.

    // === Getters y Setters ===
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderEntity> items) {
        this.items = items;
    }


}
