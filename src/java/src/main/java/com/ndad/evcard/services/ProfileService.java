package com.ndad.evcard.services;

import com.ndad.evcard.entities.Profile;
import com.ndad.evcard.entities.User;
import com.ndad.evcard.repositories.ProfileRepository;
import com.ndad.evcard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileService {

    final
    ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile getProfileById(UUID uuid) {
        Profile profile = profileRepository.findById(uuid).get();
        return profile;
    }

}
