package fr.eni.eniencheres.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;

    @Bean // On définit un bean pour la configuration des routes
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests() // ON AUTORISE
                .antMatchers(HttpMethod.GET, "/**").permitAll() // les requêtes GET
                .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() // les requêtes OPTIONS
                .antMatchers("/api/login").permitAll() // les requêtes pour se loguer
                // sinon, besoin d'être authentifie (c'est fait au niveau du filtre avec : SecurityContextHolder.getContext().setAuthentication(authenticationToken);)
                .anyRequest().authenticated()
                .and().csrf().ignoringAntMatchers("/api/**");
        //.formLogin(); commenté car on ne veut pas de redirection vers le formulaire de login
        //.formLogin(); => fotmulaire par défault de Spring ! si pas de LoginRestController
        /*****************************************************************
         * AVANT DE FAIRE LA VERIFICATION DE SECURITE, ON AJOUTE UN FILTRE qui va
         * vérifier la présence ou non d'un Json Web Token
         ******************************************************************/
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

	/*

	@Bean // On définit un bean pour la configuration des routes
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests() // ON AUTORISE
		.antMatchers(HttpMethod.GET, "/**").permitAll() // les requêtes GET
		.antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() // les requêtes OPTIONS
		.antMatchers("/api/login").permitAll() // les requêtes pour se loguer
		.anyRequest().authenticated() // sinon, besoin d'être authentifie
		.and().csrf().ignoringAntMatchers("/api/**");
	//.formLogin(); commenté car on ne veut pas de redirection vers le formulaire de login

	 */