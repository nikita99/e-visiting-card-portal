package com.ndad.evcard.entities;

import com.ndad.evcard.models.RoleName;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @Column(name = "role_id")
    Long roleId;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "name")
    RoleName name;

}
