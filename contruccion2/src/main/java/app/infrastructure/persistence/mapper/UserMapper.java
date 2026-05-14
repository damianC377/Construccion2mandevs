package app.infrastructure.persistence.mapper;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(User user){
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setFullName(user.getFullName());
        entity.setDocument(user.getDocument());
        entity.setEmailAddress(user.getEmailAddress());
        entity.setDateOfBirth(user.getDateOfBirth());
        entity.setAddress(user.getAddress());

        if (user.getRole() != null) {
            entity.setRole(user.getRole().name());
        }

        entity.setUserName(user.getUserName());
        entity.setPassword(user.getPassword());
        entity.setPhoneNumber(user.getPhoneNumber());

        return entity;
    }

    public static User toDomain(UserEntity entity){
        if (entity == null) return null;

        User user = new User();
        user.setId(entity.getId());
        user.setFullName(entity.getFullName());
        user.setDocument(entity.getDocument());
        user.setEmailAddress(entity.getEmailAddress());
        user.setDateOfBirth(entity.getDateOfBirth());
        user.setAddress(entity.getAddress());

        if (entity.getRole() != null) {
            user.setRole(Role.valueOf(entity.getRole()));
        }

        user.setUserName(entity.getUserName());
        user.setPassword(entity.getPassword());
        user.setPhoneNumber(entity.getPhoneNumber());

        return user;
    }
}

