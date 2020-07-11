package com.ndad.evcard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profile")
@Data
public class Profile {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "profile_id")
    UUID id;

    //Todo: ignore user object
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    @JsonIgnoreProperties("profile")
    User user;

    @OneToMany(mappedBy = "profile")
    List<VisitingCard> visitingCards;

}
