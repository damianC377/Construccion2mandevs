package app.domain.services;

import app.domain.model.User;
import app.domain.port.UserPort;

public class AuthenticeUserService {
	
	private UserPort userport;
	private UserLoginservice userLogin;
	
	public User authentice(String userName, String password) throws Exception {
		
		User existing = new User();
		existing.setUserName(userName);
		
		User user = userport.findByuserName(existing);
		
		if(user == null) {
			throw new Exception("Usuario no encontrado");
		}
		
		if(!user.getPassword().equals(password)) {
			throw new Exception("Contraseña incorrecta");
		}
		
		userLogin.login(user);
		
		return user;
	}
	
	
}
