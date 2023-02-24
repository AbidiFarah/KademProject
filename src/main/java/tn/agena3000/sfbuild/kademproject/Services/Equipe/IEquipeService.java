package tn.agena3000.sfbuild.kademproject.Services.Equipe;

import tn.agena3000.sfbuild.kademproject.Entity.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);

}
