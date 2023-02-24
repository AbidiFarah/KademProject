package tn.agena3000.sfbuild.kademproject.Services.Universite;

import tn.agena3000.sfbuild.kademproject.Entity.Universite;
import tn.agena3000.sfbuild.kademproject.Repository.DepartementRepository;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
