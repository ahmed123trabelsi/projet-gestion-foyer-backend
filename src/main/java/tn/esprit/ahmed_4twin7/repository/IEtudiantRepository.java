package tn.esprit.ahmed_4twin7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprit.ahmed_4twin7.entities.Etudiant;
@CrossOrigin("http://localhost:4200")
public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {
    Etudiant findByCin(long cin);
}
