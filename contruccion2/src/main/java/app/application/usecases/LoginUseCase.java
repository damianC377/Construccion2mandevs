package app.application.usecases;

import app.domain.model.User;
import app.domain.services.AuthenticeUser;
import app.domain.services.UserLogin;

public class LoginUseCase {
	private AuthenticeUser authenticeUser;
	private UserLogin userLogin;
	
	public User loginUseCase(String userName, String password) throws Exception {
		return authenticeUser.authentice(userName, password);
	}
	
	public User getUserCurrent() {
		return userLogin.getCurrent();
	}
	
	public void logout() {
		userLogin.logout();
	}
}
