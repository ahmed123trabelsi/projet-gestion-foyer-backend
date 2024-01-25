package tn.esprit.ahmed_4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ahmed_4twin7.entities.Etudiant;
import tn.esprit.ahmed_4twin7.serivce.EtudiantServiceImpl;

import java.util.List;

@Service
@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
@CrossOrigin("*")
public class EtudiantRestController {
    final EtudiantServiceImpl etudiantService;

    @GetMapping("/GETAllE")
    public List<Etudiant> retrieveAllE(){
        return this.etudiantService.retrieveAllEtudiants();
    }
    @PutMapping("/updateE/{id}")
    public Etudiant updateE(@RequestBody Etudiant e,@PathVariable long id){
        return this.etudiantService.updateEtudiant(e);
    }


    @GetMapping("/GETE/{id}")
    public Etudiant retrieveE(@PathVariable("id") long id){
        return this.etudiantService.retrieveEtudiant(id);
    }
    @DeleteMapping("/DeleteE/{id}")
    public void removeE(@PathVariable("id") long id) {
        this.etudiantService.removeEtudiant(id);
    }

    @PostMapping("/AddEE")
    public Etudiant AddEtudiant(@RequestBody Etudiant e){
        return this.etudiantService.AddEtudiant(e);
    }
}
