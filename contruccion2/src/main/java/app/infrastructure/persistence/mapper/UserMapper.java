package app.infrastructure.persistence.mapper;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.infrastructure.persistence.entities.UserEntity;


public class UserMapper {

    public static UserEntity toEntity(User user){
        if (user == null) return null;
        UserEntity Entity = new UserEntity();
        Entity.setId(user.getId());
        Entity.setFullName(user.getFullName());
        Entity.setDocument(user.getDocument());
        Entity.setEmailAddress(user.getEmailAddress());
        Entity.setDateOfBirth(user.getDateOfBirth());
        Entity.setAddress(user.getAddress());
        Entity.setRole(user.getRole().name());
        Entity.setUserName(user.getUserName());
        Entity.setPassword(user.getPassword());
        Entity.setPhoneNumber(user.getPhoneNumber());

        return Entity;
    }

    public static User toDomain(UserEntity Entity){
        if (Entity == null) return null;
        User user = new User();
        user.setId(Entity.getId());
        user.setFullName(Entity.getFullName());
        user.setDocument(Entity.getDocument());
        user.setEmailAddress(Entity.getEmailAddress());
        user.setDateOfBirth(Entity.getDateOfBirth());
        user.setAddress(Entity.getAddress());
        user.setRole(Role.valueOf(Entity.getRole()));
        user.setUserName(Entity.getUserName());
        user.setPassword(Entity.getPassword());

        return user;
    }
}
