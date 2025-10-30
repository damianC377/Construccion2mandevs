package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicationOrderValidator extends SimpleValidator {


    public String dosageValidator(String value) throws Exception {
        return stringValidator("dosis del medicamento", value);
    }

    public String treatmentDurationValidator(String value) throws Exception {
        return stringValidator("duración del tratamiento", value);
    }
}
