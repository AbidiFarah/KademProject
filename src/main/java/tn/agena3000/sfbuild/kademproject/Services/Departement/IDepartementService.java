package tn.agena3000.sfbuild.kademproject.Services.Departement;

import tn.agena3000.sfbuild.kademproject.Entity.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
