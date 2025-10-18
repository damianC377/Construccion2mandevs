package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class ProcedureOrderValidator extends SimpleValidator {

    public String procedureValidator(String value) throws Exception {
        return stringValidator("nombre del procedimiento", value);
    }

    public Integer quantityValidator(String value) throws Exception {
        return integerValidator("cantidad del procedimiento", value);
    }

    public String frequencyValidator(String value) throws Exception {
        return stringValidator("frecuencia del procedimiento", value);
    }

    public Boolean requiresSpecialistValidator(Boolean value) throws Exception {
        if (value == null) {
            throw new Exception("El campo 'requiere especialista' no puede ser nulo");
        }
        return value;
    }

    public String specialistValidator(String value) throws Exception {
        return stringValidator("tipo de especialista", value);
    }
}
