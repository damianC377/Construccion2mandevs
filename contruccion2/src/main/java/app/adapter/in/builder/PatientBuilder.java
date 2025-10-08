package app.adapter.in.builder;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PatientBuilder {

    @Autowired
    private PatientValidator patientValidator;

    public Patient build(String document, String fullName, String dateOfBirth,
                         String gender, String address, String phoneNumber,
                         String emailAddress) throws Exception {

        // Crear e inicializar los objetos que componen la entidad
        Patient patient = new Patient();
        MedicalRecord medicalRecord = new MedicalRecord();
        EmergencyContact emergencyContact = new EmergencyContact();
        HealthInsurance healthInsurance = new HealthInsurance();

        // Validar y asignar los atributos del paciente
        patient.setDocument(patientValidator.documentValidator(document));
        patient.setFullName(patientValidator.fullNameValidator(fullName));
        patient.setDateOfBirth(patientValidator.dateOfBirthValidator(dateOfBirth));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhoneNumber(patientValidator.phoneNumberValidator(phoneNumber));
        patient.setEmailAddress(patientValidator.emailAddressValidator(emailAddress));

        // Asignar los objetos inicializados a la entidad principal
        patient.setMedicalRecord(medicalRecord);
        patient.setEmergencyContact(emergencyContact);
        patient.setHealthInsurance(healthInsurance);

        return patient;
    }
}
