package com.ndad.evcard.entities;

import com.ndad.evcard.models.RoleName;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name = "role_id")
    UUID roleId;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "name")
    RoleName name;

}
