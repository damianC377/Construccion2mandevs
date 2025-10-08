package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class LoginValidaror extends SimpleValidator{
	
	public String userNameValidator(String value) throws Exception {
		return stringValidator("nombre de usuario: ", value.trim());
	}
	
	public String passwordValidator(String value) throws Exception{
		if(value.length() < 8) {
			throw new Exception("La clave debe contar con al menos 8 caracteres");
		}
		
		return value;
	}
	
}
