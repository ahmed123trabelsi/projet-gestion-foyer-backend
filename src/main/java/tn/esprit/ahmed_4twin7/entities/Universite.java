package tn.esprit.ahmed_4twin7.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long idUniversite ;

    @Column(name = "nomUniversite" , unique = true)
    String nomUniversite;

    String adresse ;

    @OneToOne(cascade ={CascadeType.PERSIST , CascadeType.REMOVE}  )
    @JoinColumn(name = "idFoyer")
    private Foyer foyer;
}
