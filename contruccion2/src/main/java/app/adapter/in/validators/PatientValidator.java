package app.adapter.in.validators;

import java.sql.Date;
import org.springframework.stereotype.Component;

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

    // Validar ID de historia médica
    public long medicalRecordIdValidator(String value) throws Exception {
        return longValidator("ID de la historia médica", value);
    }

    // Validar documento del contacto de emergencia
    public long emergencyContactDocumentValidator(String value) throws Exception {
        return longValidator("documento del contacto de emergencia", value);
    }

    // Validar número de póliza del seguro
    public long healthInsurancePolicyNumberValidator(String value) throws Exception {
        return longValidator("número de póliza del seguro", value);
    }
}
