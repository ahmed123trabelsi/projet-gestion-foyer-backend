package tn.esprit.ahmed_4twin7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ahmed_4twin7.entities.Admin;

public interface IAdminRepositries extends JpaRepository<Admin , Long> {
    boolean existsByEmail(String email);

}
