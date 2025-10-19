package app.adapter.out.persistence;

import app.domain.model.User;
import app.domain.port.UserPort;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.UserMapper;
import app.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdapter implements UserPort {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByDocument(User user){
        UserEntity userEntity = userRepository.findUserByDocument(user.getDocument());
        return UserMapper.toDomain(userEntity);
    }

    @Override
    public User findByUserName(User user) throws Exception {
        UserEntity userEntity = userRepository.findByUsername(user.getUserName());
        return UserMapper.toDomain(userEntity);
    }

    @Override
    public void save(User user) throws Exception {
        userRepository.save(UserMapper.toEntity(user));
    }
}
