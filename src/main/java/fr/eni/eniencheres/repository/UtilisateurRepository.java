package fr.eni.eniencheres.repository;

import fr.eni.eniencheres.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long > {

    public Utilisateur findByPseudo(String pseudo);

}
