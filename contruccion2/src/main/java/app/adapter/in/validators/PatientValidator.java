package app.adapter.in.validators;

import app.domain.model.MedicalRecord;
import app.domain.model.EmergencyContact;
import app.domain.model.HealthInsurance;

import java.sql.Date;

public class PatientValidator extends SimpleValidator {

    public String fullNameValidator(String value) throws Exception {
        return stringValidator("nombre completo del paciente", value);
    }

    public Date dateOfBirthValidator(String value) throws Exception {
        try {
            return Date.valueOf(value); 
        } catch (IllegalArgumentException e) {
            throw new Exception("Formato de fecha de nacimiento inválido. Usa yyyy-mm-dd");
        }
    }

    public String genderValidator(String value) throws Exception {
        return stringValidator("género del paciente", value);
    }

    public String addressValidator(String value) throws Exception {
        return stringValidator("dirección del paciente", value);
    }

    public String phoneNumberValidator(String value) throws Exception {
        return stringValidator("número de teléfono del paciente", value);
    }

    public String emailValidator(String value) throws Exception {
        return stringValidator("correo electrónico del paciente", value);
    }

    public MedicalRecord medicalRecordValidator(MedicalRecord medicalRecord) throws Exception {
        if (medicalRecord == null) {
            throw new Exception("El historial médico del paciente no puede ser nulo");
        }
        return medicalRecord;
    }

    public EmergencyContact emergencyContactValidator(EmergencyContact emergencyContact) throws Exception {
        if (emergencyContact == null) {
            throw new Exception("El contacto de emergencia del paciente no puede ser nulo");
        }
        return emergencyContact;
    }

    public HealthInsurance healthInsuranceValidator(HealthInsurance healthInsurance) throws Exception {
        if (healthInsurance == null) {
            throw new Exception("El seguro de salud del paciente no puede ser nulo");
        }
        return healthInsurance;
    }
}
