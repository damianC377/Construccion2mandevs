package app.domain.services;

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
