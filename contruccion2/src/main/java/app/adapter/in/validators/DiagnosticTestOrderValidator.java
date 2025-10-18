package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticTestOrderValidator extends SimpleValidator {

    public String diagnosticTestValidator(String value) throws Exception {
        return stringValidator("nombre de la ayuda diagnóstica", value);
    }

    public Integer quantityValidator(String value) throws Exception {
        return integerValidator("cantidad de la ayuda diagnóstica", value);
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
