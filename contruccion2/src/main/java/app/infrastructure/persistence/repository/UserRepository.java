package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findUserByDocument(long document);

    public UserEntity findByUserName(String userName);

}
