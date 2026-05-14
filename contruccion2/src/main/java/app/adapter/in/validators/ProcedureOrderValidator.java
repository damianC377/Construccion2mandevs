package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class ProcedureOrderValidator extends SimpleValidator {

    public long procedureInventoryIdValidator(String value) throws Exception{
        return longValidator("Id del procedimiento: ", value);
    }

    public Integer quantityValidator(String value) throws Exception {
        return integerValidator("cantidad del procedimiento", value);
    }

    public String frequencyValidator(String value) throws Exception {
        return stringValidator("frecuencia del procedimiento", value);
    }

    public Boolean requiresSpecialistValidator(String value) throws Exception {
        if (value == null) {
            throw new Exception("El campo 'requiere especialista' no puede ser nulo");
        }

        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")){
            throw new Exception("El campo 'requiere especialista' debe ser 'true' o 'false'");
        }

        return Boolean.parseBoolean(value);
    }

    public String specialistValidator(String value) throws Exception {
        return stringValidator("tipo de especialista", value);
    }
}
