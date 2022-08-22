package fr.eni.eniencheres.repository;

import fr.eni.enchere.trainingenchere.Bo.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnchereRepository extends JpaRepository<Enchere,Long> {
}
