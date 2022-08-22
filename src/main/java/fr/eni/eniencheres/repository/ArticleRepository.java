package fr.eni.eniencheres.repository;

import fr.eni.eniencheres.bo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
