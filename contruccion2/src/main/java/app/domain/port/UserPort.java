package app.domain.port;

import app.domain.model.User;

public interface UserPort {
	//Encuentra el documento del usuario digitado
	public User findByDocument(User user) throws Exception;
	
	//Encuentra el nombre de usuario de la persona
	public User findByUserName(User user)throws Exception;
	
	// Guarda el usuario
	public void save(User user) throws Exception;
	
	
	
}
