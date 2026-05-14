package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class EmergencyContactValidator extends SimpleValidator {

    public long documentValidator(String value) throws Exception {
        return longValidator("documento del contacto de emergencia", value);
    }

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre del contacto de emergencia", value);
    }

    public String relationshipValidator(String value) throws Exception {
        return stringValidator("relación del contacto de emergencia", value);
    }

    public String phoneNumberValidator(String value) throws Exception {
        return stringValidator("número de teléfono del contacto de emergencia", value);
    }

}
