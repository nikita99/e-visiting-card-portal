package com.ndad.evcard.repositories;

import com.ndad.evcard.entities.VisitingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitingCardRespository extends JpaRepository<VisitingCard, UUID> {

}
