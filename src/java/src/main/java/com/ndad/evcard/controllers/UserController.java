package com.ndad.evcard.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ndad.evcard.entities.User;
import com.ndad.evcard.models.ApiResponse;
import com.ndad.evcard.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{email:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getUserByEmail(@PathVariable(name = "email") String email) throws JsonProcessingException {
        User result = userService.getUserByEmail(email);
        return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
    }
}
