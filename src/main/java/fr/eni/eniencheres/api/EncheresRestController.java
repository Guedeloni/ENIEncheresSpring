package fr.eni.eniencheres.api;

import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Categorie;
import fr.eni.eniencheres.bo.Enchere;
import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.service.ArticleService;
import fr.eni.eniencheres.service.EnchereService;
import fr.eni.eniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/encheres")

public class EncheresRestController {


    @Autowired
    EnchereService enchereService;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    ArticleService articleService;

    @GetMapping
    public List<Enchere> getlistEnchere(){return enchereService.listEnchere();}

    @GetMapping("{id}")
    public Enchere getEnchereById(@PathVariable long id) {return enchereService.getEnchereById(id);}


    @PostMapping("/{articleId}/{utilisateurId}")
    public Enchere postEnchere(@PathVariable long articleId,@PathVariable long utilisateurId, @RequestBody Enchere enchere) {



            Article article = articleService.getArticleById(articleId);
            enchere.setArticle(article);

            Utilisateur utilisateur = utilisateurService.getUtilisateurById(utilisateurId);
            enchere.setUtilisateur(utilisateur);
            //enchereService.addEnchere(enchere);


            enchere.setDateEnchere(LocalDate.now());
            //enchere.setMontantEnchere(montant);

            enchereService.addEnchere(enchere);




        return enchere;
    }

}
