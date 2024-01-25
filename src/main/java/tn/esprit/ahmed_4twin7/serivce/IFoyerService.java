package tn.esprit.ahmed_4twin7.serivce;

import tn.esprit.ahmed_4twin7.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer ajouterFoyer (Foyer f);
    Foyer updatefoyer (Foyer f);
    void supprimer (long idFoyer);
    Foyer getFoyer (long idFoyer);
    List<Foyer> getAllFoyer();
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer ,long idUniversite);
    List<String> findUnivSansFoyer ();

    List<String> findFbyBloc ();

}
