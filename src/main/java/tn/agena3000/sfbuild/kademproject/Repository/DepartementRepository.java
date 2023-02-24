package tn.agena3000.sfbuild.kademproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.agena3000.sfbuild.kademproject.Entity.Departement;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
