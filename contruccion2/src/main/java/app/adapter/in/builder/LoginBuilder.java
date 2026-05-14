package app.adapter.in.builder;

import app.adapter.in.validators.LoginValidaror;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginBuilder {

    @Autowired
	private LoginValidaror loginValidator;
	
	public User build(String userName, String password) throws Exception {
		
		User user = new User();
		
		user.setUserName(loginValidator.userNameValidator(userName));
		user.setPassword(loginValidator.passwordValidator(password));
		
		return user;
	}
}
