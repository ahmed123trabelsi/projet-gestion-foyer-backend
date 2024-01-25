package tn.esprit.ahmed_4twin7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ahmed_4twin7.entities.Chambre;
import tn.esprit.ahmed_4twin7.serivce.IChambreService;

import java.util.List;

@RequestMapping("/chambre")
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")

public class ChambreRestController {
    private final IChambreService chambreService ;

    @GetMapping ("/GetAllChambre")
    public List<Chambre> getallchambre (){
        return chambreService.retrieveAllChambres();
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return this.chambreService.addChambre(chambre);
    }

    @GetMapping("/getChambre/{id}")
    public Chambre getchambre(@PathVariable("id") long id) {
        return this.chambreService.retrieveChambreById(id);
    }

    @PutMapping ("/Update/{id}")
    public Chambre upadteCh (@RequestBody Chambre chambre,@PathVariable Long id){
        return this.chambreService.updateChambre(chambre);
    }


//    @GetMapping("getChambresParBlocEtType/{idBloc}/{type}")
//    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc, @PathVariable TypeChambre type) {
//        return chambreService.getChambresParBlocEtType(idBloc,type);
//    }

}

