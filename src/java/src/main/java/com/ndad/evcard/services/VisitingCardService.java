package com.ndad.evcard.services;

import com.ndad.evcard.entities.User;
import com.ndad.evcard.entities.VisitingCard;
import com.ndad.evcard.repositories.UserRepository;
import com.ndad.evcard.repositories.VisitingCardRespository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class VisitingCardService {

    private final VisitingCardRespository visitingCardRespository;
    private final UserRepository userRepository;

    public VisitingCardService(VisitingCardRespository visitingCardRespository, UserRepository userRepository) {
        this.visitingCardRespository = visitingCardRespository;
        this.userRepository = userRepository;
    }

    public VisitingCard createVisitingCardForId(VisitingCard visitingCard, UUID uuid) {
        User user = userRepository.findById(uuid).get();
        visitingCard.setProfile(user.getProfile());
        return visitingCardRespository.save(visitingCard);
    }

    public VisitingCard getVisitingCardById(UUID uuid) throws NoSuchElementException {
        return visitingCardRespository.findById(uuid).get();
    }
}

