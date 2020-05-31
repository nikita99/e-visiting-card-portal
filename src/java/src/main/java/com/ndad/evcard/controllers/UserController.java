package com.ndad.evcard.controllers;

import com.ndad.evcard.entities.User;
import com.ndad.evcard.services.OAuth2UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final OAuth2UserService OAuth2UserService;

    public UserController(OAuth2UserService OAuth2UserService) {
        this.OAuth2UserService = OAuth2UserService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User result = OAuth2UserService.createUser(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByEmail(@RequestParam(name = "email") String email) {
        User result = OAuth2UserService.getUserByEmail(email);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
