package tn.agena3000.sfbuild.kademproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.agena3000.sfbuild.kademproject.Entity.Contrat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Integer countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nomE,String prenpmE);




    @Query("""
            select c from Contrat c
            where c.archive = false and c.etudiant.departement.idDepart = ?1 and c.dateDebutContrat between ?2 and ?3 or c.dateFinContrat between ?4 and ?5
            order by c.specialite""")
    List<Contrat> findByArchiveFalseAndEtudiant_Departement_IdDepartAndDateDebutContratBetweenOrDateFinContratBetweenAndOrderBySpecialite(int etudiant_departement_idDepart, Date dateDebut,Date dateFin);




// List<Contrat> findByEtudiantDepartementUniversiteIdAndDateFinAndDateDebut
//         (Long universiteId, Date dateDebut, Date dateFin);
//d
// List<Contrat> findByArchiveFalseAndArchiveBetween
//
//
// (Date startDate, Date endDate);


    Integer countByArchiveIsFalseAndDateDebutContratAfterAndDateFinContratbefore(Date startDate, Date endDate);

    List<Contrat> findByArchiveIsFalseAndDateFinContrat(LocalDate nowDate);
    @Query("select c from Contrat c where c.archive = false and c.dateFinContrat between ?1 and ?2")
    List<Contrat> findByArchiveIsFalseAndDateFinContratBetween(LocalDate nowDate , LocalDate datePlus15);

    @Query("select c from Contrat c where c.archive = false and c.dateDebutContrat >= ?1 and c.dateFinContrat <= ?2")
    List<Contrat> findByArchiveFalseAndEtudiant_Departement_IdDepartAndDateDebutContratIsGreaterThanEqualAndDateFinContratIsLessThanEqual(Integer idDepart ,LocalDate endDate , LocalDate startDate);



}
