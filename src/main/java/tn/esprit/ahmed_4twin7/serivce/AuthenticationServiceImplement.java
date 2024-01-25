package tn.esprit.ahmed_4twin7.serivce;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.ahmed_4twin7.Authentication.AuthenticationResponse;
import tn.esprit.ahmed_4twin7.Security.JwtService;
import tn.esprit.ahmed_4twin7.entities.Erole;
import tn.esprit.ahmed_4twin7.entities.Etudiant;
import tn.esprit.ahmed_4twin7.entities.User;
import tn.esprit.ahmed_4twin7.repository.IEtudiantRepository;
import tn.esprit.ahmed_4twin7.repository.IUserRepositries;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplement implements IAuthenticationServices {
    private final IUserRepositries iUserRepositries;
    private final IEtudiantRepository iEtudiantRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public Etudiant registerEtudiant(Etudiant etudiant) {
        if (iUserRepositries.existsByEmail(etudiant.getEmail())) {
            throw new RuntimeException("Email déjà utilisé. Choisissez un autre email.");
        }
        etudiant.setPassword(passwordEncoder.encode(etudiant.getPassword()));
        etudiant.setRole(Erole.ETUDIANT);
        return iEtudiantRepository.save(etudiant);
    }

    public boolean emailExists(String email) {
        // Logique pour vérifier si l'e-mail existe déjà dans la base de données
        return iUserRepositries.existsByEmail(email);
    }

    public AuthenticationResponse login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        var user = iUserRepositries.findByEmail(email).orElseThrow(() -> new RuntimeException("utilisateur non trouvé"));
        var jwt = jwtService.generateToken(user);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(jwt);

        if (user.getRole() == Erole.ETUDIANT) {
            Etudiant etudiant = (Etudiant) user;
            Etudiant etudiantDto = convertToEtudiantDto(etudiant);
            authenticationResponse.setUser(etudiantDto);
        } else {
            User userDetails = convertToUserDto(user);
            authenticationResponse.setUser(userDetails);
        }

        return authenticationResponse;
    }

    private User convertToUserDto(User user) {
        User dto = new User();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setPrenom(user.getPrenom());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }

    private Etudiant convertToEtudiantDto(Etudiant etudiant) {
        Etudiant dto = new Etudiant();
        dto.setId(etudiant.getId());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setEmail(etudiant.getEmail());
        dto.setPassword(etudiant.getPassword());
        dto.setRole(etudiant.getRole());
        dto.setCin(etudiant.getCin());
        dto.setEcole(etudiant.getEcole());
        dto.setDateNaissance(etudiant.getDateNaissance());
        return dto;
    }
}
