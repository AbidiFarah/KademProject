package tn.agena3000.sfbuild.kademproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.agena3000.sfbuild.kademproject.Entity.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{
    Optional<Etudiant> findByNomAndPrenom(String nom, String prenom);

}
