package app.adapter.in.builder;

import app.adapter.in.validators.UserValidator;
import app.domain.model.User;


public class UserBuilder {

    private UserValidator userValidator;

    public UserBuilder(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public User build(String fullName, String document, String emailAddress,
                      String phoneNumber, String dateOfBirth, String address,
                      String userName, String password) throws Exception {

        User user = new User();
        user.setFullName(userValidator.fullNameValidator(fullName));
        user.setDocument(userValidator.documentValidator(document));
        user.setEmailAddress(userValidator.emailValidator(emailAddress));
        user.setPhoneNumber(userValidator.phoneNumberValidator(phoneNumber));
        user.setDateOfBirth(userValidator.dateOfBirthValidator(dateOfBirth));
        user.setAddress(userValidator.addressValidator(address));
        user.setUserName(userValidator.userNameValidator(userName));
        user.setPassword(userValidator.passwordValidator(password));

        return user;
    }
    
    public User buildUpdate(String fullName, String document, String emailAddress,
            String phoneNumber, String dateOfBirth, String address,
            String userName, String password) throws Exception {
    	
    	User user = new User();
    	
    	if(!fullName.isBlank()) {
    		user.setFullName(userValidator.fullNameValidator(fullName));
    	}
    	
    	if(!document.isBlank()) {
    		user.setDocument(userValidator.documentValidator(document));
    	}
    	
    	if(!emailAddress.isBlank()) {
    		user.setEmailAddress(userValidator.emailValidator(emailAddress));
    	}
    	
    	if(!phoneNumber.isBlank()) {
    		user.setPhoneNumber(userValidator.phoneNumberValidator(phoneNumber));
    	}
    	
    	if(!dateOfBirth.isBlank()) {
    		user.setDateOfBirth(userValidator.dateOfBirthValidator(dateOfBirth));
    	}
    	
    	if(!address.isBlank()) {
    		user.setAddress(userValidator.addressValidator(address));
    	}
    	
    	if(!userName.isBlank()) {
    		user.setUserName(userValidator.userNameValidator(userName));
    	}
    	
    	if(!password.isBlank()) {
    		user.setPassword(userValidator.passwordValidator(password));
    	}
    	
    	
    	return user;
    }
}


