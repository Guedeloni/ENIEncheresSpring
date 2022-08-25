package fr.eni.eniencheres.api;


import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Retrait;
import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.security.JwtUtils;
import fr.eni.eniencheres.security.User;
import fr.eni.eniencheres.service.ArticleService;
import fr.eni.eniencheres.service.RetraitService;
import fr.eni.eniencheres.service.UtilisateurService;
import fr.eni.eniencheres.util.ENIEncheresException;
import fr.eni.eniencheres.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    RetraitService retraitService;

    @GetMapping
    public List<Article> getlistArticle(){return articleService.listeArticle();}

    @GetMapping("{id}")
    public Article getArticleById(@PathVariable long id) {return articleService.getArticleById(id);}

    @PostMapping
    public Article postArticle(@RequestBody Article article, @AuthenticationPrincipal User currentUser) throws ENIEncheresException {

        // Si pas de date debut d'enchere ; date du jour par defaut
        if (article.getDateDebutEncheres() == null) {
            article.setDateDebutEncheres(LocalDate.now());
        }

        // Etat de vente a 1 (creation)
        article.setEtatVente(1);

        // Ajout de l'utilisateur connecte en tant que vendeur ds. article
        article.setVendeur(currentUser.getUtilisateur());

        // Adresse de retrait par defaut = adresse de l'utilisateur connecte
        if (article.getRetrait().getRue()           == "" ||
            article.getRetrait().getCodePostal()    == "" ||
            article.getRetrait().getVille()         == "") {
            Retrait retrait = new Retrait(utilisateurService.getUtilisateurById(utilisateurId).getRue(),
                                        utilisateurService.getUtilisateurById(utilisateurId).getCodePostal(),
                                        utilisateurService.getUtilisateurById(utilisateurId).getVille());
            article.setRetrait(retrait);
        }

        try {
            articleService.addArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ENIEncheresException(Message.PB_CREATION_ARTICLE.showMsg());
        }

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
