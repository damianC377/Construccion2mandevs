package app.domain.services;

public class UserRequireAuthenticatedService {
	
	//Variable para acceder a la clase AuthUserService y utilizar la sesion guardada
		private UserLoginservice currentUser;
	
	//Metodo para saber si user existe
	public void requireAuthenticated() throws Exception {
		if(currentUser.getCurrent() == null) {
			throw new Exception("No existe usuario autenticado");
		}
	
	}
	
}
