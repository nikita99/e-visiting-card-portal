/*
package com.ndad.evcard.controllers;

import com.ndad.evcard.entities.VisitingCard;
import com.ndad.evcard.models.ApiResponse;
import com.ndad.evcard.services.VisitingCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/evcard")
public class VisitingCardController {
    private final VisitingCardService visitingCardService;

    public VisitingCardController(VisitingCardService visitingCardService) {
        this.visitingCardService = visitingCardService;
    }

    @PostMapping(value = "/email/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> createVisitingCard(@RequestBody VisitingCard visitingCard, @PathVariable("email") String email) {
        VisitingCard result = visitingCardService.createVisitingCardForEmail(visitingCard, email);
        return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.CREATED);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getVisitingCardById(@PathVariable("id") UUID uuid) {
        VisitingCard result = visitingCardService.getVisitingCardById(uuid);
        return new ResponseEntity<>(new ApiResponse(result, true), HttpStatus.OK);
    }
}
*/
