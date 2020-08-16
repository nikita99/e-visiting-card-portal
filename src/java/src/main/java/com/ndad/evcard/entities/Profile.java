package com.ndad.evcard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profile")
@Data
public class Profile {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "profile_id")
    UUID profileId;

    //Todo: ignore user object
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    @JsonIgnoreProperties("profile")
    User user;

    @OneToMany(mappedBy = "profile")
    List<VisitingCard> visitingCards = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "profile_receivedcards",
            joinColumns = @JoinColumn(name = "user_user_id"),
            inverseJoinColumns = @JoinColumn(name = "vcard_id"))
    @JsonIgnoreProperties("sharedWith")
    List<VisitingCard> receivedCards = new ArrayList<>();
}


//Profile
//
//Id       user
//1        nikita
//2        ashok
//
//Visiting Card
//
//Id firstname lastname company profile
//1  nikita    d        MS      1
//2  nikita    d        JP      1
//
//





