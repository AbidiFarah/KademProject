package tn.agena3000.sfbuild.kademproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.agena3000.sfbuild.kademproject.Entity.Contrat;

import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Integer countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nomE,String prenpmE);



// List<Contrat> findByEtudiantDepartementUniversiteIdAndDateFinAndDateDebut
//         (Long universiteId, Date dateDebut, Date dateFin);
//
// List<Contrat> findByArchiveFalseAndArchiveBetween
//
//
// (Date startDate, Date endDate);



}
