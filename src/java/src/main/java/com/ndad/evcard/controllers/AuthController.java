package com.ndad.evcard.controllers;

import com.ndad.evcard.models.ApiResponse;
import com.ndad.evcard.models.JwtAuthenticationResponse;
import com.ndad.evcard.models.LoginRequest;
import com.ndad.evcard.models.SignUpRequest;
import com.ndad.evcard.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    AuthenticationManager authenticationManager;

    final
    AuthService authService;

    public AuthController(AuthenticationManager authenticationManager, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        String jwt = authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<>(new JwtAuthenticationResponse(jwt), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest) throws Exception {
        ApiResponse response = authService.signUp(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword());

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/user/{email}").buildAndExpand(signUpRequest.getEmail()).toUri();

        return ResponseEntity.created(location).body(response);
    }
}
