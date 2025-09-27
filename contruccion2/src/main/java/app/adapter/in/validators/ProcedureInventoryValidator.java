package app.adapter.in.validators;

public class ProcedureInventoryValidator extends SimpleValidator {

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre del procedimiento", value.trim());
    }

    public double costValidator(String value) throws Exception {
        return doubleValidator("costo del procedimiento", value);
    }
}
