package tn.agena3000.sfbuild.kademproject.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idDepart;
    String nomDepart;
}
