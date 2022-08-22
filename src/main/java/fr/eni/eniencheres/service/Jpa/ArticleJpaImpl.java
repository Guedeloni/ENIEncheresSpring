package fr.eni.eniencheres.service.Jpa;

import fr.eni.enchere.trainingenchere.Bo.Article;
import fr.eni.enchere.trainingenchere.repository.ArticleRepository;
import fr.eni.enchere.trainingenchere.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j

public class ArticleJpaImpl implements ArticleService {


    @Autowired
    ArticleRepository articleRepository;


    @Override
    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public List<Article> listeArticle() {
        return articleRepository.findAll();
    }



    @Override
    public Article getArticleById(long id) {
        return articleRepository.findById(id).get();
    }
}
