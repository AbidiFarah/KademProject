package tn.agena3000.sfbuild.kademproject.Services.Contrat;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.agena3000.sfbuild.kademproject.Entity.Contrat;
import tn.agena3000.sfbuild.kademproject.Entity.Etudiant;
import tn.agena3000.sfbuild.kademproject.Repository.ContratRepository;
import tn.agena3000.sfbuild.kademproject.Repository.EtudiantRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContratService implements IContratService{

    private  final ContratRepository contratRepository;
    private  final EtudiantRepository etudiantRepository;

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

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.delete(retrieveContrat(idContrat));

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomAndPrenom(nomE,prenomE).orElse(null);
        if (etudiant == null || etudiant.getContrats().size() >= 5) {
            return null;
        }
        // Assign the contract to the student
        ce.setEtudiant(etudiant);
        etudiant.getContrats().add(ce);
        etudiantRepository.save(etudiant);
        return ce;
    }
}