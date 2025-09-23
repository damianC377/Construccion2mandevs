package app.adapter.in.validators;

import java.sql.Date;

public class UserValidator extends SimpleValidator {

    public String fullNameValidator(String value) throws Exception {
        return stringValidator("nombre completo de la persona", value);
    }

    public long documentValidator(String value) throws Exception {
        return longValidator("el documento de la persona", value);
    }

    public String emailValidator(String value) throws Exception {
        return stringValidator("correo electrónico", value);
    }

    public String phoneNumberValidator(String value) throws Exception {
        return stringValidator("número de teléfono", value);
    }

    public Date dateOfBirthValidator(String value) throws Exception {
        try {
        	return Date.valueOf(value);
        } catch(IllegalArgumentException e){
        	throw new Exception("Formato de fecha invalido. Usa yyyy-mm-dd");
        }
    }

    public String addressValidator(String value) throws Exception {
        return stringValidator("dirección", value);
    }


    public String userNameValidator(String value) throws Exception {
        return stringValidator("nombre de usuario", value);
    }

    public String passwordValidator(String value) throws Exception {
        return stringValidator("contraseña", value);
    }

}
