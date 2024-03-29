package com.ndad.evcard.repositories;

import com.ndad.evcard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    Optional<Boolean> existsByUsername(String username);

    Optional<Boolean> existsByEmail(String username);
}
