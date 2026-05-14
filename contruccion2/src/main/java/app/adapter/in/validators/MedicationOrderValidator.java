package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicationOrderValidator extends SimpleValidator {

    /**
     * Valida el ID del inventario de medicamentos.
     */
    public long medicationInventoryIdValidator(String value) throws Exception {
        return longValidator("ID del inventario de medicamentos", value);
    }

    /**
     * Valida la cantidad de medicamento solicitada.
     */
    public String dosageValidator(String value) throws Exception {
        return stringValidator("cantidad de medicamento", value);
    }

   public String treatmentDurationValidator(String value) throws Exception{
        return stringValidator("Duracion del medicamento", value);
   }
}
