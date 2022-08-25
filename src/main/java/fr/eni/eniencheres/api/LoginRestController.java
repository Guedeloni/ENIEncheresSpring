package fr.eni.eniencheres.api;

import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.security.JwtUtils;
import fr.eni.eniencheres.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class LoginRestController {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @PostMapping
    public String login(@RequestBody Utilisateur utilisateur) throws Exception {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(utilisateur.getPseudo(),
                utilisateur.getMotDePasse());
        Authentication authentication = authenticationConfiguration.getAuthenticationManager()
                .authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return jwt;
    }

    @GetMapping
    public Utilisateur getCurrentUser(@AuthenticationPrincipal User currentUser) {
        return currentUser.getUtilisateur();
    }

}
