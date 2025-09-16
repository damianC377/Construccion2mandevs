package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.UserPort;

public class UserAssignRoleService {
	
	private UserPort userport;
	private UserRequireRoleService userRequireRole;
	
	//Asignación de rol a usuarios
		public void assignRole(long document, Role role) throws Exception {
			
			//Se utiliza un auxiliar para almacenar el documento
			User existing = new User(); 
			existing.setDocument(document);
			
			
			User user = userport.findByDocument(existing);
			
			//Validacion de documento que exista
			if ( user == null) {
				throw new Exception("No existe una persona con esa");
			}
			
			userRequireRole.requireRole(Role.HUMAN_RESOURCES);
			
			//Si existe, asignamos el rol
			user.setRole(role);
			
			userport.save(user);
		}
}
