package app.adapter.in.validators;

import app.domain.model.*;

import java.sql.Date;
import java.util.List;

public class MedicalRecordValidator extends SimpleValidator {


    public Date orderDateValidator(String value) throws Exception {
        try {
            return Date.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new Exception("Formato de fecha de orden inválido. Usa yyyy-mm-dd");
        }
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

}

