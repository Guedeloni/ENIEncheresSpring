package fr.eni.eniencheres.service.Jpa;

import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.repository.ArticleRepository;
import fr.eni.eniencheres.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

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
    public List<Article> listeArticleBySelection(int selection) {
        switch (selection) {
            case 1  :
            case 2  :
            case 3  : {
                List<Article> listArticle = articleRepository.findByEtatVente(selection);
                return listArticle;
            }
            default: return this.listeArticle();
        }
    }

    @Override
    public Article getArticleById(long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public void deleteArticleById(Long id) { articleRepository.deleteById(id); }

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }
}
