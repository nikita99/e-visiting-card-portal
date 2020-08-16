package com.ndad.evcard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "vcards")
public class VisitingCard {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "vcard_id")
    UUID vcardId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "office")
    String office;

    @Column(name = "designation")
    String designation;

    @Column(name = "contact")
    String contact;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonIgnore
    Profile profile;

    @ManyToMany(mappedBy = "receivedCards", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"receivedCards", "visitingCards"})
    List<Profile> sharedWith = new ArrayList<>();
}
