package tn.esprit.ahmed_4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ahmed_4twin7.entities.Foyer;
import tn.esprit.ahmed_4twin7.serivce.IFoyerService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/foyer")
@RestController
@CrossOrigin("*")

public class FoyerRestController {
    private final IFoyerService foyerServices;

    @GetMapping("/GetallFoyer")
    public List<Foyer> getAllFoyer() {
        return foyerServices.getAllFoyer();
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return this.foyerServices.ajouterFoyer(f);
    }

    @PutMapping("/update/{id}")
    public Foyer updatef(@RequestBody Foyer f,@PathVariable Long id) {
        return this.foyerServices.updatefoyer(f);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteF(@PathVariable("id") long idF) {
        this.foyerServices.supprimer(idF);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer getF(@PathVariable("id") long idFoyer) {
        return this.foyerServices.getFoyer(idFoyer);
    }

    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return this.foyerServices.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }

    @GetMapping("/FindUSF")
    public List<String> findUnivSansFoyer() {
    return foyerServices.findUnivSansFoyer();
    }
    @GetMapping("/findFbyBloc")
    public List<String> findFbyBloc() {
    return foyerServices.findFbyBloc();
    }
    }
