package tn.esprit.ahmed_4twin7.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.ahmed_4twin7.entities.Reservation;

public interface IReservationRepository extends CrudRepository<Reservation ,String> {
//    @Query("SELECT COUNT (r) from Reservation r WHERE r.anneUnu BETWEEN :debutAnnee AND :finAnnee")
//    long countReservationsByAnneeUniversitaire(@Param("debutAnnee") Date debutAnnee, @Param("finAnnee") Date finAnnee);
 Reservation findReservationByEtudiant_Cin( long cinEtudiant);

}
