package com.ndad.evcard.services;

import com.ndad.evcard.entities.User;
import com.ndad.evcard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).get();
        return user;
    }

}
