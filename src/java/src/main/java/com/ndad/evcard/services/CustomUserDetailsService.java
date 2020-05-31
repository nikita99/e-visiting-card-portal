package com.ndad.evcard.services;

import com.ndad.evcard.entities.User;
import com.ndad.evcard.models.UserPrincipal;
import com.ndad.evcard.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    final
    UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("No user found for email = " + email)
        );

        return UserPrincipal.create(user);
    }

    public UserDetails loadUSerById(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("No user found for id = " + userId)
        );
        return UserPrincipal.create(user);
    }
}
