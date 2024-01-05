package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.DTOs.UserDto;
import elte.project.pcbuilder.domain.enums.Role;
import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.exception.UserAlreadyExistException;
import elte.project.pcbuilder.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elte.project.pcbuilder.domain.user.User;

import java.util.Arrays;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerNewUser(UserDto userDto) throws UserAlreadyExistException {
        if (usernameExists(userDto.getUsername())) {
            throw new UserAlreadyExistException("The username " + userDto.getUsername() + " already exists." );
        }
        User user = new User();
        Credential credential = new Credential();

        credential.setUsername(userDto.getUsername());
        credential.setPassword(userDto.getPassword());
        credential.setUser(user);
        user.setCredential(credential);

        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    private boolean usernameExists(String username) {
        return userRepository.findUserByCredentialUsername(username).isPresent();
    }

}
