package com.ndad.evcard.services;

import com.ndad.evcard.entities.Profile;
import com.ndad.evcard.entities.Role;
import com.ndad.evcard.entities.User;
import com.ndad.evcard.models.ApiResponse;
import com.ndad.evcard.models.RoleName;
import com.ndad.evcard.repositories.RoleRepository;
import com.ndad.evcard.repositories.UserRepository;
import com.ndad.evcard.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService {

    final
    UserRepository userRepository;

    final
    RoleRepository roleRepository;

    final
    AuthenticationManager authenticationManager;

    final
    PasswordEncoder passwordEncoder;

    final
    JwtTokenProvider jwtTokenProvider;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    public String authenticateUser(String email, String password) throws AuthenticationException {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        return jwt;
    }

    public ApiResponse signUp(String username, String email, String password) throws Exception {

        if (userRepository.existsByUsername(username).get()) {
            return new ApiResponse("Username already taken.", false);
        }

        if (userRepository.existsByEmail(email).get()) {
            return new ApiResponse("Email already in use.", false);
        }

        User user = new User(username, email, passwordEncoder.encode(password));
        Role role = roleRepository.getByName(RoleName.ROLE_USER).orElseThrow(() -> new Exception("User Role not set"));
        user.setRoles(Collections.singleton(role));

        Profile profile = new Profile();
        profile.setUser(user);
//        profile.setVisitingCards(new ArrayList<>());
//        profile.setReceivedCards(new ArrayList<>());
        user.setProfile(profile);

        userRepository.save(user);

        return new ApiResponse("User registered successfully.", true);
    }
}
