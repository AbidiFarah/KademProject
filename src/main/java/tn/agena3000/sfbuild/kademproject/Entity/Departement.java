package tn.agena3000.sfbuild.kademproject.Entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departement {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idDepart;
    String nomDepart;
    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiants;
}


