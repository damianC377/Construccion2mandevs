package app.application.usecases;

import app.domain.model.User;
import app.domain.services.AuthenticeUser;
import app.domain.services.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {

    @Autowired
	private AuthenticeUser authenticeUser;

    @Autowired
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
