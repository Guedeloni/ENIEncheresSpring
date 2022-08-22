package fr.eni.eniencheres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class WebSecurityConfig {



    @Bean // On définit un bean pour la configuration des routes
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /**** Sur quels chemins impose-t-on d'être authentifié ****/
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin") // 1 - Si route /admin/*** => besoin d'avoir le rôle admin
                .antMatchers("/prive/**").authenticated() // 2 - Sinon, si route /prive/*** => besoin d'être authentifie
                .anyRequest().permitAll().and() 		// 3 - Sinon, on autorise les autres requêtes
                /**** On précise qu'on souhaite une authentification username/password ****/
                .formLogin();
        // .loginPage("/login"); si on veut avoir une page personalisée de login

        // permet d'éviter les erreurs 403 sur les requêtes POST d'API
        // pas idéal => normalement il faudrait gérer des json web token avec l'api
        http.csrf().disable();

        return http.build();
    }


    @Bean // on définit un bean pour l'utilitaire d'encryption de mot de passe
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
