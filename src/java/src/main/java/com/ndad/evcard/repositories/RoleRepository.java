package com.ndad.evcard.repositories;

import com.ndad.evcard.entities.Role;
import com.ndad.evcard.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> getByName(RoleName name);
}
