package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findUserByCredentialUsername(String username);
}
