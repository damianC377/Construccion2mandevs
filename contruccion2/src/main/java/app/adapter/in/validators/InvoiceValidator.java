package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class InvoiceValidator extends SimpleValidator {

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

}
