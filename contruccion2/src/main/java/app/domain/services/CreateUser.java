package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.UserPort;

public class CreateUser {
	
	private UserPort userport;
	private UserRequireRole userRequireRole;
	
	//Crear un usuario
		public void createUser(User user) throws Exception {
			
			//Validar que solo exista una persona con la cedula
			if(userport.findByDocument(user) != null) {
				throw new Exception("Ya existe una persona con esta cedula");
			}
			
			//Validacion de nombre de usuario
			if(userport.findByuserName(user) != null) {
				throw new Exception("Ya existe nombre de usuario");
				
			}
			
			userRequireRole.requireRole(Role.HUMAN_RESOURCES);
			
			userport.save(user);
			
		}
}
