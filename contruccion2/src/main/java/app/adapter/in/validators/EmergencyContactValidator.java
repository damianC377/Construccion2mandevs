package app.adapter.in.validators;

public class EmergencyContactValidator extends SimpleValidator {

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
