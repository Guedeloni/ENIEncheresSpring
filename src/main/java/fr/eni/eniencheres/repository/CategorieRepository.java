package fr.eni.eniencheres.repository;

import fr.eni.eniencheres.bo.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {


    public Categorie findByLibelle(String libelle);

    public boolean existsByLibelle(String libelle);

}
