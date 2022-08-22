package fr.eni.eniencheres.service;

import fr.eni.enchere.trainingenchere.Bo.Article;

import java.util.List;

public interface ArticleService {


    public void addArticle (Article article);


    List<Article> listeArticle();



    public Article getArticleById(long id);




}
