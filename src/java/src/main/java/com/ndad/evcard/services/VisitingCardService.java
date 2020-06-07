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

    public VisitingCard createVisitingCardForEmail(VisitingCard visitingCard, String email) {
        User user = userRepository.findByEmail(email).get();
        visitingCard.setUser(user);
        return visitingCardRespository.save(visitingCard);
    }

    public VisitingCard getVisitingCardById(UUID uuid) throws NoSuchElementException {
        return visitingCardRespository.findById(uuid).get();
    }
}
