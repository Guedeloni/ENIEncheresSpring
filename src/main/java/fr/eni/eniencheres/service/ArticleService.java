package fr.eni.eniencheres.service;

import fr.eni.eniencheres.bo.Article;

import java.util.List;

public interface ArticleService {

    public void addArticle (Article article);

    List<Article> listeArticle();

    List<Article> listeArticleBySelection(int selection);

    public Article getArticleById(long id);

    public  void deleteArticleById(Long id);

    public void updateArticle(Article article);

}
