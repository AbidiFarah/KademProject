package tn.agena3000.sfbuild.kademproject.Services.Contrat;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.agena3000.sfbuild.kademproject.Entity.*;
import tn.agena3000.sfbuild.kademproject.Repository.ContratRepository;
import tn.agena3000.sfbuild.kademproject.Repository.EtudiantRepository;
import tn.agena3000.sfbuild.kademproject.Repository.UniversiteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService {

    private final ContratRepository contratRepository;
    private final EtudiantRepository etudiantRepository;
    private final UniversiteRepository universiteRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }
    //@Scheduled(fixedRate = 60000)
    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.delete(retrieveContrat(idContrat));

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {

        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndAndPrenomE(nomE, prenomE).orElse(null);
        Assert.notNull(etudiant,"Etudiant is Null");
        Integer nbrContrats = contratRepository.countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(nomE,prenomE);
        Assert.isTrue(nbrContrats >= 5,"Nombre de contrat est >=5");


        if (etudiant == null || etudiant.getContrats().size() >= 5) {
            return null;
        }
        // Assign the contract to the student
        ce.setEtudiant(etudiant);
        etudiant.getContrats().add(ce);
        etudiantRepository.save(etudiant);
        return ce;
    }

     @Override
     public Map<Specialite, Float> getMontantContratEntreDeuxDate(Integer idUniv, LocalDate startDate, LocalDate endDate) {

        Universite universite = universiteRepository.getById(idUniv);
        List<Departement> departements = universite.getDepartements();
        Assert.isNull(departements ,"No Departement in this universty");
        Map<Departement,List<Contrat>> mapContarts =   new HashMap<>();

        departements.forEach(departement -> {
            List<Contrat> contarts = contratRepository.findByArchiveFalseAndEtudiant_Departement_IdDepartAndDateDebutContratIsGreaterThanEqualAndDateFinContratIsLessThanEqual(departement.getIdDepart(),startDate,endDate);
            return contarts.stream()
                    .collect(Collectors.groupingBy(
                            Contrat::getSpecialite,
                            Collectors.summingDouble(c -> this.calculateMontantContrat(c, startDate, endDate))
                    ))
                    .entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().floatValue()));
        }


        });
         /*for (Departement departement : departements) {
             mapContarts.put(departement,contratRepository.findByArchiveFalseAndEtudiant_Departement_IdDepartAndDateDebutContratBetweenOrDateFinContratBetweenOrderBySpecialite(departement.getIdDepart(),startDate,endDate));
         }
         Map<Specialite,Float> montantContratParSpecialite = mapContarts.entrySet().stream().collect(Map.Entry::getKey,entry));
 //     List<Contrat> contrats = contratRepository.findByEtudiantDepartementUniversiteIdAndDateFinAndDateDebut((long) idUniv, startDate, endDate);
 //      Map<Specialite, Float> montantContratParSpecialite = new HashMap<>();
         // for (Contrat contrat : contrats) {
//            Specialite specialite = contrat.getSpecialite();
//            Float montantContrat = montantContratParSpecialite.get(specialite);
//            if (montantContrat == null) {
//                montantContrat = 0f;
//            }
//            montantContrat += contrat.getMontantContrat();
//            montantContratParSpecialite.put(specialite, montantContrat);
//        }
//        return montantContratParSpecialite;*/

         return null;
      }

    private double calculateMontantContrat(Contrat contrat, LocalDate startDate, LocalDate endDate) {
        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDateTime contratStart = contrat.getDateDebutContrat().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime contratEnd = contrat.getDateFinContrat().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        LocalDate dateDebut = startLocalDate.isAfter(contratStart.toLocalDate()) ? startLocalDate : contratStart.toLocalDate();
        LocalDate dateFin = endLocalDate.isBefore(contratEnd.toLocalDate()) ? endLocalDate : contratEnd.toLocalDate();

        double montantContrat = contrat.getMontantContrat();
        long diffDays = ChronoUnit.DAYS.between(dateDebut, dateFin);
        double montantContratEntreDates = (montantContrat / (double) diffDays) * (double) diffDays;

        return (montantContratEntreDates >= 0) ? montantContratEntreDates : 0;
    }
    @Override
   public Integer nbContratsValides(Date startDate, Date endDate) {
     Integer nbrContrats = contratRepository.countByArchiveIsFalseAndDateDebutContratAfterAndDateFinContratbefore(startDate,endDate);
       return nbrContrats;
    }
    @Scheduled(cron = "0 0 13 * * ?") // exécution tous les jours à 13h
    @Override
    public String retrieveAndUpdateStatusContrat() {
         contratRepository.findByArchiveIsFalseAndDateFinContrat(LocalDate.now())
                .stream()
                .forEach(contrat -> {
                    contrat.setArchive(true);
                    System.out.println("Le contrat " + contrat.getIdContrat() + " est archivé.");
                });
         contratRepository.findByArchiveIsFalseAndDateFinContratBetween(LocalDate.now() , LocalDate.now().plusDays(15))
                 .stream()
                 .forEach(contrat -> System.out.println("Le contrat " + contrat.getIdContrat() + " est doit expiré dans 15 jours  Le "+ contrat.getDateFinContrat()));
        return "Les contrats dont la date de fin est aujourd'hui ont été archivés.";
    }





}
