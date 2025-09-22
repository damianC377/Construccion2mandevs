package app.application.usecases;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.services.CreateUserService;
import app.domain.services.UpdateUserService;

public class Human_ResourcesUseCase {
	
	private CreateUserService createUser;
	private UpdateUserService updateUserService;
	
	public void createDoctor(User user) throws Exception {
		user.setRole(Role.DOCTOR);
		createUser.createUser(user);
	}
	
	public void createNurse(User user) throws Exception {
		user.setRole(Role.NURSE);
		createUser.createUser(user);
	}
	
	public void createADMINISTRATOR(User user) throws Exception {
		user.setRole(Role.ADMINISTRATOR);
		createUser.createUser(user);
	}
	
	public void createADMINISTRATIVE_STAFF(User user) throws Exception {
		user.setRole(Role.ADMINISTRATIVE_STAFF);
		createUser.createUser(user);
	}
	
	public void createHUMAN_RESOURCES(User user) throws Exception {
		user.setRole(Role.HUMAN_RESOURCES);
		createUser.createUser(user);
	}
	
	public void createSUPPORT(User user) throws Exception {
		user.setRole(Role.DOCTOR);
		createUser.createUser(user);
	}

	public void updateUser(long document, User newdata) throws Exception{
		updateUserService.updateUser(document, newdata);
	}

	
}
