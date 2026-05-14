package app.infrastructure.persistence.entities;

import java.sql.Date;
import jakarta.persistence.*;


@Entity
@Table(name = "patients")
public class PatientEntity {

    // ID único generado automáticamente para cada paciente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private long document;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false, length = 20)
    private String gender;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    // Relación con contacto de emergencia (1:1)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_contact_id")
    private EmergencyContactEntity emergencyContact;

    // Relación con seguro médico (1:1)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "health_insurance_id")
    private HealthInsuranceEntity healthInsurance;

    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmergencyContactEntity getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactEntity emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public HealthInsuranceEntity getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsuranceEntity healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
}
