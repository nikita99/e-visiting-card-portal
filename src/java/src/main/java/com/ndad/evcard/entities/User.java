package com.ndad.evcard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "user_id")
    @JsonIgnore
    UUID userId;

    @Column(name = "username")
    String username;

    @Column(name = "email")
    String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<VisitingCard> visitingCards;
}
