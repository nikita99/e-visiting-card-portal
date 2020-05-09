package com.ndad.evcard.services;

import com.ndad.evcard.entities.VisitingCard;
import com.ndad.evcard.repositories.VisitingCardRespository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class VisitingCardService {

    private final VisitingCardRespository visitingCardRespository;

    public VisitingCardService(VisitingCardRespository visitingCardRespository) {
        this.visitingCardRespository = visitingCardRespository;
    }

    public VisitingCard createVisitingCard(VisitingCard visitingCard) {
        return visitingCardRespository.save(visitingCard);
    }

    public VisitingCard getVisitingCardById(UUID uuid) throws NoSuchElementException {
        return visitingCardRespository.findById(uuid).get();
    }
}
