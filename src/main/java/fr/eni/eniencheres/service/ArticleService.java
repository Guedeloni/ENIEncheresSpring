package fr.eni.eniencheres.service;

import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Utilisateur;

import java.util.List;

public interface ArticleService {

    public void addArticle (Article article);

    List<Article> listeArticle();

    List<Article> listeArticleByProfilAndSelection(Utilisateur vendeur, int selection);

    public Article getArticleById(long id);

    public  void deleteArticleById(Long id);

    public void updateArticle(Article article);

}
