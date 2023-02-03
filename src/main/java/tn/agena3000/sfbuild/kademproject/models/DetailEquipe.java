package tn.agena3000.sfbuild.kademproject.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

@Entity
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idDetailEquipe;
    int salle;
    String thematique;
}
