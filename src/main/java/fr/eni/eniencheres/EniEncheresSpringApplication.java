package fr.eni.eniencheres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EniEncheresSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EniEncheresSpringApplication.class, args);
	}

	@Bean // on définit un bean pour l'utilitaire d'encryption de mot de passe
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
