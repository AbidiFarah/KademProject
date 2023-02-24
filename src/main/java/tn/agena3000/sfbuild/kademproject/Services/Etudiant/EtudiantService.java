package tn.agena3000.sfbuild.kademproject.Services.Etudiant;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.agena3000.sfbuild.kademproject.Entity.Contrat;
import tn.agena3000.sfbuild.kademproject.Entity.Departement;
import tn.agena3000.sfbuild.kademproject.Entity.Equipe;
import tn.agena3000.sfbuild.kademproject.Entity.Etudiant;
import tn.agena3000.sfbuild.kademproject.Repository.ContratRepository;
import tn.agena3000.sfbuild.kademproject.Repository.DepartementRepository;
import tn.agena3000.sfbuild.kademproject.Repository.EquipeRepository;
import tn.agena3000.sfbuild.kademproject.Repository.EtudiantRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EtudiantService implements IEtudiantService{

    private final EtudiantRepository etudiantRepository ;
    private final ContratRepository contratRepository;
    private final EquipeRepository equipeRepository;
    private DepartementRepository departementRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public void addEtudiant(Etudiant e) {
         etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        Etudiant e = retrieveEtudiant(idEtudiant);
        etudiantRepository.delete(e);

    }
    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        //récupération des objets
        // Etudiant etudiant = this.getById(etudiantId);
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);

        //vérification des objets
        if ((etudiant!=null) && (departement!=null)) {
            //traitement
            etudiant.setDepartement(departement);
            //departement.getEtu().add(etudiant);
            //saving
            etudiantRepository.save(etudiant);
        }
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        if(e == null && contrat == null && equipe == null )  {
            return null;
        }
        contrat.setEtudiant(e);
        e.getContrats().add(contrat);
        e.getEquipes().add(equipe);
        etudiantRepository.save(e);
        return e;

    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        if(departement == null ){
            return null ;
        }
        return departement.getEtudiants();
    }
}
