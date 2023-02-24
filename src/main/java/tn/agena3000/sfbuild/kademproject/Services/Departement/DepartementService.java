package tn.agena3000.sfbuild.kademproject.Services.Departement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.agena3000.sfbuild.kademproject.Entity.Departement;
import tn.agena3000.sfbuild.kademproject.Entity.Universite;
import tn.agena3000.sfbuild.kademproject.Repository.DepartementRepository;
import tn.agena3000.sfbuild.kademproject.Repository.UniversiteRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartementService implements IDepartementService{
private final DepartementRepository departementRepository;
private final UniversiteRepository universiteRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if(universite == null){
            return null;
        }

        return universite.getDepartements();
    }
}
