package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    public User authenticateUser(Credential credential){
        Optional<User> loggedInUser = userRepository.findUserByCredentialUsername(credential.getUsername());
        if(loggedInUser.isPresent() && loggedInUser.get().getCredential().getPassword().equals(credential.getPassword())){
            return loggedInUser.get();
        } else {
            return new User();
        }
    }

    public void register(User user){
        userRepository.save(user);
    }

}
