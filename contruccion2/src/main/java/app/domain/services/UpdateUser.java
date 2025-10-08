package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.port.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {
    @Autowired
	private UserPort userport;
    @Autowired
	private UserRequireRole userRequireRole;
	
	//Actualizar datos del usuario
		public void updateUser(long document, User newdata) throws Exception{

			
			//Se utiliza una variable para almacenarlo
			User existing = new User();
			existing.setDocument(document);
			
			User user =  userport.findByDocument(existing);
			
			//Validamos el documento
			if ( user == null) {
				throw new Exception("No existe una persona");
			}
			
			//Se validan que los datos escritos no esten vacios
			if(newdata.getFullName() != null) {
				existing.setFullName(newdata.getFullName());
			}
			
			if(newdata.getEmailAddress() != null) {
				existing.setEmailAddress(newdata.getEmailAddress());
			}
			
			if(newdata.getPhoneNumber() != null) {
				existing.setPhoneNumber(newdata.getPhoneNumber());
			}
			
			if(newdata.getDateOfBirth() != null) {
				existing.setDateOfBirth(newdata.getDateOfBirth());
			}
			
			if(newdata.getAddress() != null) {
				existing.setAddress(newdata.getAddress());
			}

			if (newdata.getRole() != existing.getRole() && newdata.getRole() != null) {
				user.setRole(newdata.getRole());
			}
			
			userRequireRole.requireRole(Role.HUMAN_RESOURCES);
			
			userport.save(existing);
		}
}
