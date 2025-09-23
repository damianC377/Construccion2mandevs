package app.adapter.in.builder;

import app.adapter.in.validators.UserValidator;
import app.domain.model.User;


public class UserBuilder {

    private final UserValidator userValidator;

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
}


