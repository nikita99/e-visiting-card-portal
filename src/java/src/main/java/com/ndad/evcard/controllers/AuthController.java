package com.ndad.evcard.controllers;

import com.ndad.evcard.models.ApiResponse;
import com.ndad.evcard.models.JwtAuthenticationResponse;
import com.ndad.evcard.models.LoginRequest;
import com.ndad.evcard.models.SignUpRequest;
import com.ndad.evcard.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    final
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        String jwt = authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<>(new ApiResponse(new JwtAuthenticationResponse(jwt), true), HttpStatus.OK);
    }

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) throws Exception {
        ApiResponse response = authService.signUp(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword());

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/user/{email}").buildAndExpand(signUpRequest.getEmail()).toUri();

        return (response.getSuccess()) ? ResponseEntity.created(location).body(response) : ResponseEntity.badRequest().body(response);
    }
}
