package app.domain.services;

import app.domain.model.User;

public class UserLoginservice {
	
	//Variable que se usa a futuro para guardar la sesión
	private User currentUser;
	
	//Este Recibe un parametro al momento de iniciar sesión validando al usuario
	public void login(User user) throws Exception {
		if(user == null) {
			throw new Exception("Usuario invalido");
		}
		
		currentUser = user;

	}
	
	public void logout() {
		currentUser = null;
	}
	
	//Trae el usuario de la sesion iniciada
	public User getCurrent() {
		return currentUser;
	}
	
}
