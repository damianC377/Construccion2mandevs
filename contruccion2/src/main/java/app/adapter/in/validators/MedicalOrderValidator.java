package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class MedicalOrderValidator extends SimpleValidator {

    public long orderNumberValidator(String value) throws Exception {
        return longValidator("número de orden médica", value);
    }

    public Date orderDateValidator(String value) throws Exception {
        try {
            return Date.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new Exception("La fecha de la orden médica es inválida. Usa el formato yyyy-mm-dd");
        }
    }

    public String itemValidator(String value) throws Exception {
        // Validamos cada ítem de la lista de órdenes (medicamentos, procedimientos, diagnósticos)
        return stringValidator("ítem de la orden médica", value.trim());
    }
}
