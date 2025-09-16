package app.domain.services;

import app.domain.model.enums.Role;

public class UserRequireRoleService {
	
	//Variable para acceder a la clases
		private UserLoginservice currentUser;
		private UserRequireAuthenticatedService userRequireAuthenticated;
		
	//Este valida que el usuario con la sesion, tenga el rol para a función	
	public void requireRole(Role requiredRole) throws Exception {
		userRequireAuthenticated.requireAuthenticated();
		if(currentUser.getCurrent().getRole() != requiredRole) {
			throw new Exception("Usuario no autorizado");
		}
	}
}
