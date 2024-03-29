package tn.esprit.ahmed_4twin7.serivce;

import tn.esprit.ahmed_4twin7.entities.Etudiant;

import java.util.List;

public interface IEtudiantService  {

    Etudiant AddEtudiant(Etudiant e);
    Etudiant updateEtudiant (Etudiant e);
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
}
