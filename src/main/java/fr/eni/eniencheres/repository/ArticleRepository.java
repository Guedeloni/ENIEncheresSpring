package fr.eni.eniencheres.repository;

import fr.eni.enchere.trainingenchere.Bo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
