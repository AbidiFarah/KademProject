package tn.agena3000.sfbuild.kademproject.Services.Contrat;

import tn.agena3000.sfbuild.kademproject.Entity.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant (Contrat ce,String nomE,String prenomE);
}
