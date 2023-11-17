package elte.project.pcbuilder.repository;

import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByCredential(Credential credential);
}
