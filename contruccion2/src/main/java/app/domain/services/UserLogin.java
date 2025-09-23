package app.domain.services;

import app.domain.model.User;

public class UserLogin {
	
	//Variable que se usa a futuro para guardar la sesión
	private User currentUser;
	private int failedattempts = 0;
	private int maxattempts = 3;
	
	//Este Recibe un parametro al momento de iniciar sesión validando al usuario
	public void login(User user) throws Exception {
				
		if(user == null) {
			registerFailedAttempts();
			throw new Exception("Usuario invalido");
		}
		
		if(failedattempts >= maxattempts) {
			throw new Exception("Cuenta bloqueada por demasiados intentos");
		}
		
		currentUser = user;
		failedattempts = 0;

	}
	
	public void logout() {
		currentUser = null;
	}
	
	public void registerFailedAttempts() {
		failedattempts++;
	}
	
	//Trae el usuario de la sesion iniciada
	public User getCurrent() {
		return currentUser;
	}
	
}
