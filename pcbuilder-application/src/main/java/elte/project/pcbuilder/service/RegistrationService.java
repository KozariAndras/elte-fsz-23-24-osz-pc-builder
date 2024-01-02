package elte.project.pcbuilder.service;

import elte.project.pcbuilder.domain.user.Credential;
import elte.project.pcbuilder.domain.user.User;
import elte.project.pcbuilder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void registerUser(User user, Credential credential) {
        // additional validation and error handling can be added here
        user.setCredential(credential);
        userRepository.save(user);
    }
}
