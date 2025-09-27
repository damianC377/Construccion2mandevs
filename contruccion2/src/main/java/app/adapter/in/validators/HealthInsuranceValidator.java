package app.adapter.in.validators;

import java.sql.Date;

import app.domain.model.Patient;

public class HealthInsuranceValidator extends SimpleValidator {

    public String companyNameValidator(String value) throws Exception {
        return stringValidator("nombre de la compañia de seguro", value);
    }

    public String policyNumberValidator(String value) throws Exception {
        return stringValidator("número de póliza", value);
    }

    public boolean activeValidator(String value) throws Exception {
        if (value == null || value.isEmpty()) {
            throw new Exception("el estado de la póliza no puede ser vacío o nulo");
        }
        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
            throw new Exception("el estado de la póliza debe ser 'true' o 'false'");
        }
        return Boolean.parseBoolean(value);
    }

    public Date endDateValidator(String value) throws Exception {
        if (value == null || value.isEmpty()) {
           
            throw new Exception("la fecha de finalización no puede ser vacía o nula");
        }
        try {
            return Date.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new Exception("Formato de fecha inválido para la fecha de finalización. Usa yyyy-mm-dd");
        }
    }
}
