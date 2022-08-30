package fr.eni.eniencheres.repository;

import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByEtatVente(int etatVente);
    public List<Article> findByVendeur(Utilisateur vendeur);
    public List<Article> findByVendeurAndEtatVente(Utilisateur vendeur, int etatVente);
    public List<Article> findByVendeurAndEtatVenteBetween(Utilisateur vendeur, int minEtatVente, int maxEtatVente);

}
