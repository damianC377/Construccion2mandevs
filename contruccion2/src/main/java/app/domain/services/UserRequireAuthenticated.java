package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequireAuthenticated {
	
	//Variable para acceder a la clase AuthUserService y utilizar la sesion guardada
    private UserLogin currentUser;
	
	//Metodo para saber si user existe
	public void requireAuthenticated() throws Exception {
		if(currentUser.getCurrent() == null) {
			throw new Exception("No existe usuario autenticado");
		}
	
	}
	
}
