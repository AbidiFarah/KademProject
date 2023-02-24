package tn.agena3000.sfbuild.kademproject.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    int idDetailEquipe;
    int salle;
    String thematique;
}
