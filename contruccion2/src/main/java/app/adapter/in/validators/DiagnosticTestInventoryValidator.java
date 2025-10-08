package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticTestInventoryValidator extends SimpleValidator {

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre del test diagnóstico", value.trim());
    }

    public double costValidator(String value) throws Exception {
        return doubleValidator("costo del test diagnóstico", value);
    }
}
