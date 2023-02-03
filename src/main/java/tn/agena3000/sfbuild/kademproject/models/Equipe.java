package tn.agena3000.sfbuild.kademproject.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipe {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idEquipe;
    String nomEquipe;
    Niveau niveau;
    @ManyToMany(
            mappedBy = "Equipes"
    )
    private Set<Etudiant> membres = new HashSet();
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    private DetailEquipe detailequipe;
}
