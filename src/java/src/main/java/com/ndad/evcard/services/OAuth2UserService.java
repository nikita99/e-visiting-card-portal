/*
package com.ndad.evcard.services;

import com.ndad.evcard.entities.User;
import com.ndad.evcard.repositories.UserRepository;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class OAuth2UserService extends OidcUserService {
    private final UserRepository userRepository;

    public OAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest oidcUserRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(oidcUserRequest);
        Map attributes = oidcUser.getAttributes();
        User user = new User();
        user.setUsername((String) attributes.get("name"));
        user.setEmail((String) attributes.get("email"));
        updateUser(user);
        return oidcUser;
    }

    public User updateUser(User userInfo) {
        User user = getUserByEmail(userInfo.getEmail());
        if (user == null) {
            return createUser(userInfo);
        }
        user.setUsername(userInfo.getUsername());
        user.setEmail(userInfo.getEmail());
        return userRepository.save(user);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
}
*/
