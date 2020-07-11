package com.ndad.evcard.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ndad.evcard.entities.Profile;
import com.ndad.evcard.models.ApiResponse;
import com.ndad.evcard.models.UserPrincipal;
import com.ndad.evcard.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getAuthenticatedProfile() throws JsonProcessingException {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UUID uuid = userPrincipal.getUserId();
        Profile result = profileService.getProfileById(uuid);
        return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
    }

}
