package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;
import app.adapter.rest.request.UserRequest;
import app.adapter.rest.response.UserResponse;
import app.domain.model.User;
import app.adapter.in.builder.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserRestMapper {

    @Autowired
    private UserBuilder userBuilder;

    public User toDomain(UserRequest req) throws Exception {
        if (req == null) return null;
        User u = userBuilder.build(
                req.getFullName(),
                req.getDocument(),
                req.getEmailAddress(),
                req.getPhoneNumber(),
                req.getDateOfBirth(),
                req.getAddress(),
                req.getUserName(),
                req.getPassword()
        );
        return u;
    }

    public UserResponse toResponse(User u) {
        if (u == null) return null;
        UserResponse res = new UserResponse();
        res.setDocument(u.getDocument());
        res.setUserName(u.getUserName());
        res.setRole(u.getRole() != null ? u.getRole().name() : null);
        return res;
    }
}
