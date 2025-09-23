package app.adapter.in.validators;

public class MedicationInventoryValidator extends SimpleValidator {

    public long idValidator(String value) throws Exception {
        return longValidator("el id del medicamento", value);
    }

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre del medicamento", value);
    }

    public double costValidator(String value) throws Exception {
        try {
            double cost = Double.parseDouble(value);
            if (cost < 0) {
                throw new Exception("El costo del medicamento no puede ser negativo");
            }
            return cost;
        } catch (NumberFormatException e) {
            throw new Exception("El costo del medicamento debe ser un número válido");
        }
    }
}

