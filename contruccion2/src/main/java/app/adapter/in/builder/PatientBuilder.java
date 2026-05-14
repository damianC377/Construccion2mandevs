package app.adapter.in.builder;

import app.adapter.in.validators.*;
import app.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientBuilder {

    @Autowired
    private PatientValidator patientValidator;

    public Patient build(String document, String fullName, String dateOfBirth,
                         String gender, String address, String phoneNumber,
                         String emailAddress, String medicalRecordId,
                         String emergencyContactDocument, String healthInsurancePolicyNumber) throws Exception {

        // Crear e inicializar los objetos que componen la entidad
        Patient patient = new Patient();
        MedicalRecord medicalRecord = new MedicalRecord();
        EmergencyContact emergencyContact = new EmergencyContact();
        HealthInsurance healthInsurance = new HealthInsurance();

        // Validar y asignar los atributos generales del paciente
        patient.setDocument(patientValidator.documentValidator(document));
        patient.setFullName(patientValidator.fullNameValidator(fullName));
        patient.setDateOfBirth(patientValidator.dateOfBirthValidator(dateOfBirth));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhoneNumber(patientValidator.phoneNumberValidator(phoneNumber));
        patient.setEmailAddress(patientValidator.emailAddressValidator(emailAddress));

        // Validar y asignar las relaciones del paciente
        medicalRecord.setId(patientValidator.medicalRecordIdValidator(medicalRecordId));
        emergencyContact.setDocument(patientValidator.emergencyContactDocumentValidator(emergencyContactDocument));
        healthInsurance.setPolicyNumber(patientValidator.healthInsurancePolicyNumberValidator(healthInsurancePolicyNumber));

        // Asociar las entidades relacionadas al paciente principal
        patient.setMedicalRecord(medicalRecord);
        patient.setEmergencyContact(emergencyContact);
        patient.setHealthInsurance(healthInsurance);

        return patient;
    }
}
