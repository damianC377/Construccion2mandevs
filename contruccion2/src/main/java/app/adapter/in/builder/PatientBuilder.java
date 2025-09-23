package app.adapter.in.builder;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.Patient;
import app.domain.model.MedicalRecord;
import app.domain.model.EmergencyContact;
import app.domain.model.HealthInsurance;

import java.sql.Date;

public class PatientBuilder {

    private final PatientValidator patientValidator;

    public PatientBuilder(PatientValidator patientValidator) {
        this.patientValidator = patientValidator;
    }

    public Patient build(String fullName, String dateOfBirth, String gender, String address,
                         String phoneNumber, String emailAddress, MedicalRecord medicalRecord,
                         EmergencyContact emergencyContact, HealthInsurance healthInsurance) throws Exception {

        Patient patient = new Patient();

        patient.setFullName(patientValidator.fullNameValidator(fullName));
        patient.setDateOfBirth(patientValidator.dateOfBirthValidator(dateOfBirth));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhoneNumber(patientValidator.phoneNumberValidator(phoneNumber));
        patient.setEmailAddress(patientValidator.emailValidator(emailAddress));
        patient.setMedicalRecord(patientValidator.medicalRecordValidator(medicalRecord));
        patient.setEmergencyContact(patientValidator.emergencyContactValidator(emergencyContact));
        patient.setHealthInsurance(patientValidator.healthInsuranceValidator(healthInsurance));

        return patient;
    }
}
