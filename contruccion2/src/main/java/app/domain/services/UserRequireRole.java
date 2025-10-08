package app.domain.services;

import app.domain.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequireRole {
	
	//Variable para acceder a la clases
    private UserLogin currentUser;
    @Autowired
    private UserRequireAuthenticated userRequireAuthenticated;
		
	//Esté válida que el usuario con la sesión, tenga el rol para a función
	public void requireRole(Role requiredRole) throws Exception {
		userRequireAuthenticated.requireAuthenticated();
		if(currentUser.getCurrent().getRole() != requiredRole) {
			throw new Exception("Usuario no autorizado, debe tener el rol de: " + requiredRole);
		}
	}
}
