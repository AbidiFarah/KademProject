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
public class Universite {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idUniv;
    String nomUniv;
    @OneToMany
    private List<Departement> Departements;

}
