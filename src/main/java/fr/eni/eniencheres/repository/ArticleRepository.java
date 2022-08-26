package fr.eni.eniencheres.repository;

import fr.eni.eniencheres.bo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByEtatVente(int etatVente);

}
