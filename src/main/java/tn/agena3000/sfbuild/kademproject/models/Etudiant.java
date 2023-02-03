package tn.agena3000.sfbuild.kademproject.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    int idEtudiant;
    String prenomE;
    String nomE;
    Option option;
    @OneToMany(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "fk_et_id"
    )
    private List<Contrat> contrats;
    @ManyToMany
    @JoinTable(
            name = "Etudiant_Equipe",
            joinColumns = {@JoinColumn(
                    name = "Etudiant_ID"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "Equipe_ID"
            )}
    )
    private Set<Equipe> Equipes = new HashSet();
}
