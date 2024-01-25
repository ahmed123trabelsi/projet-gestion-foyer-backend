package tn.esprit.ahmed_4twin7.Authentication;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ahmed_4twin7.entities.Etudiant;
import tn.esprit.ahmed_4twin7.entities.User;
import tn.esprit.ahmed_4twin7.repository.IEtudiantRepository;
import tn.esprit.ahmed_4twin7.repository.IUserRepositries;
import tn.esprit.ahmed_4twin7.serivce.IAuthenticationServices;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name="AUTHENTIFICATION")
@CrossOrigin("*")
public class AuthController {
    private final IAuthenticationServices services;
    private final IEtudiantRepository iEtudiantRepository;
    private final IUserRepositries iUserRepositries ;

    @PostMapping("/registerEtudiant")
    public ResponseEntity<Etudiant> registerEtudiant(@RequestBody Etudiant etudiant) { // @ModelAttribute Cette annotation permet de lier automatiquement les paramètres de la requête aux propriétés d'un objet.
        // Appel à un service pour enregistrer l'étudiant
        Etudiant savedEtudiant = services.registerEtudiant(etudiant);

        // Renvoi de la réponse avec l'étudiant enregistré
        return ResponseEntity.ok(savedEtudiant);
    }
    @GetMapping("/checkEmailExists")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = iUserRepositries.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody User user) {
        return services.login(user.getEmail() , user.getPassword());
    }

}
