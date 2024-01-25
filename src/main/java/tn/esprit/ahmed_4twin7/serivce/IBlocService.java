package tn.esprit.ahmed_4twin7.serivce;

import tn.esprit.ahmed_4twin7.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);

    public Bloc affecterChambresABloc(List<Long> idChambre, long idBloc) ;
    public Bloc affecterBlocAFoyer(long idBloc, long idFoyer) ;

}
