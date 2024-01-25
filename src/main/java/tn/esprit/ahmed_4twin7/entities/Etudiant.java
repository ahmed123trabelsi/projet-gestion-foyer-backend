package tn.esprit.ahmed_4twin7.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant extends User {

    long cin ;

    String ecole ;

    @JsonIgnore
    @ManyToMany (mappedBy="etudiant")
    Set<Reservation> reservations ;





}
