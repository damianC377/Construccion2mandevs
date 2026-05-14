package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticTestOrderValidator extends SimpleValidator {

    public long diagnosticTestInventoryIdValidator(String value) throws Exception{
        return longValidator("Id del diagnostico: ", value);
    }

    public Integer quantityValidator(String value) throws Exception {
        return integerValidator("cantidad de la ayuda diagnóstica", value);
    }

    public boolean requiresSpecialistValidator(String value) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new Exception("El campo 'requiere especialista' no puede estar vacío");
        }

        value = value.toLowerCase();

        if (!value.equals("true") && !value.equals("false")) {
            throw new Exception("El campo 'requiere especialista' debe ser 'true' o 'false'");
        }

        return Boolean.parseBoolean(value);
    }

    public String specialistValidator(String value) throws Exception {
        return stringValidator("tipo de especialista: ", value);
    }
}
