package fr.eni.eniencheres.repository;

import fr.eni.eniencheres.bo.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnchereRepository extends JpaRepository<Enchere,Long> {
}
