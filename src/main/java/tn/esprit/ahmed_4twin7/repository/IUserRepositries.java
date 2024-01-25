package tn.esprit.ahmed_4twin7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ahmed_4twin7.entities.Erole;
import tn.esprit.ahmed_4twin7.entities.User;

import java.util.Optional;

public interface IUserRepositries extends JpaRepository<User , Long> {
Optional<User> findByEmail(String email);
boolean existsByEmail(String email);
    User findByRole(Erole role);
}
