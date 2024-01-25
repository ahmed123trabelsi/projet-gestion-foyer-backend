package tn.esprit.ahmed_4twin7.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
//    private static final String SECRET_KEY ="8FE776920A8D94D307156C6E50BC391D9DD18ECF050B5C206EEBFC7D1E5C02C6";
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject) ;
    }

    //Extract claims
    public <T> T extractClaim(String token , Function<Claims, T> claimsTFunction){
        final Claims claims=extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    //Generate Token
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Check if this token is valid or not
    public boolean isTokenValid(String token , UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    //Methode use in the methode isTokenValid
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //Methode is used in the methode is token expired
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    //Exctract all claims
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey()) //Sign key is a secret that is used to gigitally sign the jwt also is using to create the signature part of the jwt which is used to verify that the sender of the jwt
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode("8FE776920A8D94D307156C6E50BC391D9DD18ECF050B5C206EEBFC7D1E5C02C6");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
