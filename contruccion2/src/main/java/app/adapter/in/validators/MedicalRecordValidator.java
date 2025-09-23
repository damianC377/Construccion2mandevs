package app.adapter.in.validators;

import app.domain.model.*;

import java.sql.Date;
import java.util.List;

public class MedicalRecordValidator extends SimpleValidator {

    public Patient patientValidator(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }
        return patient;
    }

    public Date orderDateValidator(String value) throws Exception {
        try {
            return Date.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new Exception("Formato de fecha de orden inválido. Usa yyyy-mm-dd");
        }
    }

    public User doctorValidator(User doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("El doctor no puede ser nulo");
        }
        return doctor;
    }

    public String consultationReasonValidator(String value) throws Exception {
        return stringValidator("motivo de la consulta", value);
    }

    public String symptomsValidator(String value) throws Exception {
        return stringValidator("síntomas", value);
    }

    public String diagnosisValidator(String value) throws Exception {
        return stringValidator("diagnóstico", value);
    }

    public List<MedicalOrder> ordersValidator(List<MedicalOrder> orders) throws Exception {
        if (orders == null || orders.isEmpty()) {
            throw new Exception("La lista de órdenes médicas no puede estar vacía ni ser nula");
        }
        return orders;
    }
}

