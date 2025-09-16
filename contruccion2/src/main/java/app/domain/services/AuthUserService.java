package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;

public class AuthUserService {
	
	private User currentUser;
	
	public void login(User user) throws Exception {
		if(user == null) {
			throw new Exception("Usuario invalido");
		}
		
		currentUser = user;

	}
	
	public void logout() {
		currentUser = null;
	}
	
	public void requireAuthenticated() throws Exception {
		if(currentUser == null) {
			throw new Exception("No existe usuario autenticado");
		}
	}
	
	public void requireRole(Role requiredRole) throws Exception {
		requireAuthenticated();
		if(currentUser.getRole() != requiredRole) {
			throw new Exception("Usuario no autorizado");
		}
	}
	
	public void requireAnyRole(Role...roles) throws Exception {
		requireAuthenticated();
		for(Role role : roles) {
			if(currentUser.getRole() == role) {
				return;
			}
		}
	
		throw new Exception("Usuario no autorizado, no tienes un rol valido para esta acción");
	}
	
	
	public User getCurrent() {
		return currentUser;
	}
	
}
