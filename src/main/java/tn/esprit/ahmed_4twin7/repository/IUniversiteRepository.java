package tn.esprit.ahmed_4twin7.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ahmed_4twin7.entities.Universite;

public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByNomUniversite (String nomUniv);
//    @Query("select u from Universite u where u.foyer.idFoyer=:i")
}
