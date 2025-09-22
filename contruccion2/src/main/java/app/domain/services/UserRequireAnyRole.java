package app.domain.services;

import app.domain.model.enums.Role;

public class UserRequireAnyRole {
	
	private UserLogin currentUser;
	private UserRequireAuthenticated userRequireAuthenticated;
	

	public void requireAnyRole(Role...roles) throws Exception {
		userRequireAuthenticated.requireAuthenticated();
		for(Role role : roles) {
			if(currentUser.getCurrent().getRole() == role) {
				return;
			}
		}
		
		throw new Exception("Usuario no autorizado, no tienes un rol valido para esta acción");
	}
	
	
}
