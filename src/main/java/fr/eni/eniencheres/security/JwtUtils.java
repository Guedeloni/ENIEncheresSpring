package fr.eni.eniencheres.security;

import fr.eni.eniencheres.bo.Utilisateur;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
    // jwtSecret : sert à encrypter le Json Web Token
    // Reste côté serveur, c'est ce secret qui nous garantie qu'un token qu'on recupère a été géneré par nous
    private String jwtSecret = "secret";

    /**
     * Crée un Json Web token
     * Qui contient la donnée : "username" : userPrincipal.getUsername()
     * Avec l'algorithme HMAC256 et le secret "secret"
     */
    public String generateJwtToken(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();
        // .withClaim : définit un attribut qui sera présente dans la partie "payload" du token
        return JWT.create().withClaim("username", userPrincipal.getUsername()).sign(Algorithm.HMAC256(jwtSecret));
    }


    /**
     * Renvoie la donnée "username" d'un Json Web token
     * Après l'avoir decodé avec l'algorithme HMAC256 et le secret "secret"
     */
    public String getUserNameFromJwtToken(String token) {
        return JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(token).getClaim("username").asString();
    }


    /**
     * Valide bien que le token a été encodé avec l'algorithme HMAC256 et le secret "secret"
     */
    public boolean validateJwtToken(String authToken) {
        try {
            JWT.require(Algorithm.HMAC256(jwtSecret)).build().verify(authToken);
            return true;
        } catch (Exception e) {
            System.out.println("error : " + e.getStackTrace());
        }
        return false;
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }

}
