package tn.agena3000.sfbuild.kademproject.Services.Universite;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.agena3000.sfbuild.kademproject.Entity.Departement;
import tn.agena3000.sfbuild.kademproject.Entity.Universite;
import tn.agena3000.sfbuild.kademproject.Repository.DepartementRepository;
import tn.agena3000.sfbuild.kademproject.Repository.UniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteService  implements IUniversiteService{

    private final UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Assert.isNull(universite,"The university is null ");
        Assert.isNull(departement,"The departement is null ");
            universite.getDepartements().add(departement);
            universiteRepository.save(universite);
    }
}
