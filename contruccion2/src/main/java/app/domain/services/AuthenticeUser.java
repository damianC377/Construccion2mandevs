package app.domain.services;

import app.domain.model.User;
import app.domain.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticeUser {
    @Autowired
	private UserPort userport;
    @Autowired
	private UserLogin userLogin;
	
	public User authentice(String userName, String password) throws Exception {

		User existing = new User();
		existing.setUserName(userName.trim().toLowerCase());
		
		User user = userport.findByuserName(existing);
		
		if(user == null) {
			throw new Exception("Usuario no encontrado");
		}
		
		if(!user.getPassword().equals(password)) {
			userLogin.registerFailedAttempts();
			throw new Exception("Contraseña incorrecta");
		}
		
		userLogin.login(user);
		
		return user;
	}
	
	
}
