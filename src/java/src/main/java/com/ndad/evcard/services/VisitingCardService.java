package com.ndad.evcard.services;

import com.ndad.evcard.entities.Profile;
import com.ndad.evcard.entities.User;
import com.ndad.evcard.entities.VisitingCard;
import com.ndad.evcard.repositories.ProfileRepository;
import com.ndad.evcard.repositories.UserRepository;
import com.ndad.evcard.repositories.VisitingCardRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class VisitingCardService {

    private final VisitingCardRespository visitingCardRespository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public VisitingCardService(VisitingCardRespository visitingCardRespository, UserRepository userRepository, ProfileRepository profileRepository) {
        this.visitingCardRespository = visitingCardRespository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    public VisitingCard createVisitingCardForId(VisitingCard visitingCard, UUID uuid) {
        User user = userRepository.findById(uuid).get();
        visitingCard.setProfile(user.getProfile());
        return visitingCardRespository.save(visitingCard);
    }

    public VisitingCard getVisitingCardById(UUID uuid) throws NoSuchElementException {
        return visitingCardRespository.findById(uuid).get();
    }

    public String shareVisitingCard(UUID vcardId, String receiverEmail) {
        VisitingCard visitingCard = visitingCardRespository.findById(vcardId).get();

        User receiver = userRepository.findByEmail(receiverEmail).get();
        Profile receiverProfile = receiver.getProfile();
        if(!receiverProfile.getReceivedCards().contains(visitingCard)) {
            receiverProfile.getReceivedCards().add(visitingCard);
            visitingCard.getSharedWith().add(receiverProfile);
            profileRepository.save(receiverProfile);
        }else{
            return "Already shared!";
        }

        return "Shared successfully!";
    }
}

