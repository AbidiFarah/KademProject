package tn.agena3000.sfbuild.kademproject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
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
    @JsonIgnore
    private List<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailequipe;
}
