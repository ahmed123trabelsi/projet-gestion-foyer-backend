package tn.esprit.ahmed_4twin7.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ahmed_4twin7.entities.Bloc;
import tn.esprit.ahmed_4twin7.entities.Foyer;

import java.util.List;

public interface IBlocRepository extends CrudRepository<Bloc,Long> {
    Bloc findByNomBloc (String nom);
    List<Bloc> findByFoyer(Foyer foyer);




}
