package fr.eni.eniencheres.repository;

import fr.eni.eniencheres.bo.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnchereRepository extends JpaRepository<Enchere,Long> {
    List<Enchere> findByUtilisateurId(long id);
}
