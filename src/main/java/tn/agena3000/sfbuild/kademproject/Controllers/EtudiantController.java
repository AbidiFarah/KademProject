package tn.agena3000.sfbuild.kademproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.agena3000.sfbuild.kademproject.Entity.Etudiant;
import tn.agena3000.sfbuild.kademproject.Services.Etudiant.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantController  {
    //@Autowired
    private final IEtudiantService iEtudiantService;

    @GetMapping()
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> listEtudiants = iEtudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    @GetMapping("/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        return iEtudiantService.retrieveEtudiant(etudiantId);
    }
    @PostMapping()
    public void addEtudiant(@RequestBody Etudiant e) {
        // Etudiant etudiant = iEtudiantService.addEtudiant(e);
         iEtudiantService.addEtudiant(e);
    }
    @DeleteMapping("/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        iEtudiantService.removeEtudiant(etudiantId);
    }
    @PutMapping()
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateEtudiant(e);
    }
    @GetMapping("{depatartement-id}")

    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("depatartement-id") Integer idDepartement) {
        return iEtudiantService.getEtudiantsByDepartement(idDepartement );
    }
    @GetMapping("{contart-id}/{equipe-id}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e ,@PathVariable("contart-id") Integer idContart , @PathVariable("equipe-id") Integer idEquipe ) {
        return iEtudiantService.addAndAssignEtudiantToEquipeAndContract( e,idContart, idEquipe);
    }
    @PostMapping("{etudiant-id}/{departement-id}")
    public void addAndAssignEtudiantToEquipeAndContract(@PathVariable("etudiant-id") Integer idEtudiant , @PathVariable("departement-id") Integer idDepartement ) {
      iEtudiantService.assignEtudiantToDepartement(idEtudiant ,idDepartement );
    }

}
