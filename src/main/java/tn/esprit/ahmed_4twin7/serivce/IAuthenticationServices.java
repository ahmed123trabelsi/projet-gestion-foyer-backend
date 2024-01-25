package tn.esprit.ahmed_4twin7.serivce;

import tn.esprit.ahmed_4twin7.Authentication.AuthenticationResponse;
import tn.esprit.ahmed_4twin7.entities.Etudiant;

public interface IAuthenticationServices {
    public Etudiant registerEtudiant(Etudiant etudiant);

    AuthenticationResponse login(String email, String password);
}
