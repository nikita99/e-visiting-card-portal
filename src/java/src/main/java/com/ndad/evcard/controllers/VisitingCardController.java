package com.ndad.evcard.controllers;

import com.ndad.evcard.entities.VisitingCard;
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

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VisitingCard> createVisitingCard(@RequestBody VisitingCard visitingCard) {
        VisitingCard result = visitingCardService.createVisitingCard(visitingCard);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VisitingCard> getVisitingCardById(@PathVariable("id") UUID uuid) {
        VisitingCard result = visitingCardService.getVisitingCardById(uuid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
