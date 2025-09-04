package app.domain.services;

import app.domain.enums.Role;
import app.domain.model.User;
import app.domain.port.UserPort;

public class UserService {
	
	private UserPort userport;
	
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
		
		userport.save(user);
		
	}
	
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
		
		//Si existe, asignamos el rol
		user.setRole(role);
		
		userport.save(user);
	}
	
	//Actualizar datos del usuario
	public void updateUser(long document, User newdata) throws Exception{
		
		//Se utiliza una variable para almacenarlo
		User existing = new User();
		existing.setDocument(document);
		
		User user =  userport.findByDocument(existing);
		
		//Validamos el documento
		if ( user == null) {
			throw new Exception("No existe una persona con esa");
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
		
		userport.save(existing);
	}
	
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
		
		return user;
	}
	
	
}
