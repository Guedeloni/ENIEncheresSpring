package fr.eni.eniencheres.api;


import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Categorie;
import fr.eni.eniencheres.bo.Retrait;
import fr.eni.eniencheres.service.ArticleService;
import fr.eni.eniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/articles")
public class ArticleRestController {


    @Autowired
    ArticleService articleService;
    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping
    public List<Article> getlistArticle(){return articleService.listeArticle();}

    @GetMapping("{id}")
    public Article getArticleById(@PathVariable long id) {return articleService.getArticleById(id);}

    @PostMapping("{utilisateurId}")
    public Article postArticle(@PathVariable long utilisateurId, @RequestBody Article article) throws Exception {

        // Si pas de date debut d'enchere ; date du jour par defaut
        if (article.getDateDebutEncheres() == null) {
            article.setDateDebutEncheres(LocalDate.now());
        }

        // Etat de vente a 1 (creation)
        article.setEtatVente(1);

        // Ajout a la liste des articles "vendus" (ou en cours de vente)
        List<Article> articleVenduList = utilisateurService.getUtilisateurById(utilisateurId).getArticleVenduList();
        articleVenduList.add(article);

        articleService.addArticle(article);

        return article;
    }
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        if(id !=null) {
            articleService.deleteArticleById(id);
        }
    }

    @PutMapping("/{id}")
    public void updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
    }
}
