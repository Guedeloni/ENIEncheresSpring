package fr.eni.eniencheres.api;

import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
