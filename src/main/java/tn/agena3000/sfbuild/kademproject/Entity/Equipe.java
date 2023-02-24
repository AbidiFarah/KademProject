package tn.agena3000.sfbuild.kademproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipe {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idEquipe;
    private String nomEquipe;
    private Niveau niveau;
    @ManyToMany(mappedBy = "Equipes")
    private List<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailequipe;
}
