package tn.agena3000.sfbuild.kademproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.agena3000.sfbuild.kademproject.Entity.Equipe;
import tn.agena3000.sfbuild.kademproject.Entity.Option;
import tn.agena3000.sfbuild.kademproject.Entity.Specialite;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
      List<Equipe> findAllByEtudiantsOptionAndEtudiantsContratsSpecialite(Option option , Specialite specialiteContart);

     // List<Equipe> findAllByNiveau_JuniorAndNiveau_Senior


}
