package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class PatientValidator extends SimpleValidator {

    public long documentValidator(String value) throws Exception {
        return longValidator("documento del paciente", value);
    }

    public String fullNameValidator(String value) throws Exception {
        return stringValidator("nombre completo del paciente", value);
    }

    public Date dateOfBirthValidator(String value) throws Exception {
        try {
            return Date.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new Exception("Formato de fecha inválido. Usa yyyy-mm-dd");
        }
    }

    public String genderValidator(String value) throws Exception {
        return stringValidator("género del paciente", value);
    }

    public String addressValidator(String value) throws Exception {
        return stringValidator("dirección del paciente", value);
    }

    public String phoneNumberValidator(String value) throws Exception {
        return stringValidator("número de teléfono del paciente", value);
    }

    public String emailAddressValidator(String value) throws Exception {
        return stringValidator("correo electrónico del paciente", value);
    }
}
