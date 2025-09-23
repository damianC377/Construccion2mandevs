package app.adapter.in.validators;

import app.domain.model.*;

import java.sql.Date;

public class InvoiceValidator extends SimpleValidator {

    public Patient patientValidator(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }
        return patient;
    }

    public User doctorValidator(User doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("El doctor no puede ser nulo");
        }
        return doctor;
    }

    public HealthInsurance insuranceValidator(HealthInsurance insurance) throws Exception {
        if (insurance == null) {
            throw new Exception("El seguro de salud no puede ser nulo");
        }
        return insurance;
    }

    public String policyNumberValidator(String value) throws Exception {
        return stringValidator("número de póliza", value);
    }

    public int policyValidityDaysValidator(String value) throws Exception {
        return integerValidator("días de validez de la póliza", value);
    }

    public Date policyEndDateValidator(String value) throws Exception {
        try {
            return Date.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new Exception("Formato de fecha de fin de póliza inválido. Usa yyyy-mm-dd");
        }
    }

    public MedicalOrder medicalOrderValidator(MedicalOrder medicalOrder) throws Exception {
        if (medicalOrder == null) {
            throw new Exception("La orden médica no puede ser nula");
        }
        return medicalOrder;
    }
}
