package app.adapter.in.builder;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.MedicalRecord;
import app.domain.model.Patient;

public class PatientBuilder {

    private PatientValidator patientValidator;

    public Patient builder(String fullName, String dateOfBirth, String gender, String address,
                           String phoneNumber, String emailAddress) throws Exception {

        Patient patient = new Patient();
        patient.setFullName(patientValidator.fullNameValidator(fullName));
        patient.setDateOfBirth(patientValidator.dateOfBirthValidator(dateOfBirth));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhoneNumber(patientValidator.phoneNumberValidator(phoneNumber));
        patient.setEmailAddress(patientValidator.emailAddressValidator(emailAddress));

        return patient;
    }
}
