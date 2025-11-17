package app.adapter.in.validators;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class HealthInsuranceValidator extends SimpleValidator {

    public String companyNameValidator(String value) throws Exception {
        return stringValidator("nombre de la compañia de seguro", value);
    }

    public long policyNumberValidator(String value) throws Exception {
        return longValidator("número de póliza", value);
    }

    public boolean activeValidator(String value) throws Exception {
        if (value == null || value.isBlank()) {
            throw new Exception("el estado de la póliza no puede ser vacío o nulo");
        }
        
        value = value.trim();
        		
        if(value.equalsIgnoreCase("s")) {
        	return true;
        } else if(value.equalsIgnoreCase("n")) {
        	return false;
        }else {
        	throw new Exception("El estado de la póliza debe ser 's'(Si) o 'n'(No)");
        }
    }

    public Date endDateValidator(String value) throws Exception {
        if (value == null || value.isEmpty()) {
           
            throw new Exception("la fecha de finalización no puede ser vacía o nula");
        }
        try {
            return Date.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new Exception("Formato de fecha inválido para la fecha de finalización. Usa yyyy-mm-dd");
        }
    }
}
