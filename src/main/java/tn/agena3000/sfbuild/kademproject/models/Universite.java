package tn.agena3000.sfbuild.kademproject.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.List;

@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idUniv;
    String nomUniv;
    @OneToMany(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "fk_Universite_id"
    )
    private List<Departement> Departements;

}
