package fr.eni.eniencheres.api;

import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Enchere;
import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.security.User;
import fr.eni.eniencheres.service.ArticleService;
import fr.eni.eniencheres.service.EnchereService;
import fr.eni.eniencheres.service.UtilisateurService;
import fr.eni.eniencheres.util.ENIEncheresException;
import fr.eni.eniencheres.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("{articleId}")
    public Enchere getLastEnchereByArticleId(@PathVariable long articleId) {
        Article article = articleService.getArticleById(articleId);
        List<Enchere> enchereList = article.getEnchereList() ;
        return enchereList.get(enchereList.size()-1);
    }

    @PostMapping("/{articleId}")
    public Enchere postEnchere(@PathVariable long articleId, @AuthenticationPrincipal User currentUser,
                               @RequestBody Enchere enchere) throws ENIEncheresException {

        Article article = articleService.getArticleById(articleId);

        // L'enchère doit avoir debutee et ne pas etre finie
        // La date du jour doit etre >= date debut enchere
        if (LocalDate.now().compareTo(article.getDateDebutEncheres()) == -1) {
            throw new ENIEncheresException(Message.ENCHERE_NON_DEBUTEE.showMsg());
        }
        // et date du jour doit etre <= date fin enchere
        if (LocalDate.now().compareTo(article.getDateFinEncheres()) == 1) {
            throw new ENIEncheresException(Message.ENCHERE_TERMINEE.showMsg());
        }

        // L'utilisateur ne doit pas etre le vendeur :
        Utilisateur utilisateur = currentUser.getUtilisateur();
        if (utilisateur.equals(article.getVendeur())) {
            throw new ENIEncheresException(Message.VENDEUR_NON_AUTORISE.showMsg());
        }

        // Le montant doit etre superieur au prix initial (liste d'enchere de l'article vide)
        List<Enchere> enchereListFromArticle = article.getEnchereList();
        if (enchereListFromArticle.isEmpty()) {
            if (enchere.getMontantEnchere() <= article.getPrixInitial()) {
                throw new ENIEncheresException(Message.MONTANT_ENCHERE_INSUFFISANT.showMsg());
            }
        // ni a la derniere enchere
        } else if (enchere.getMontantEnchere() <=
                    enchereListFromArticle.get(enchereListFromArticle.size()-1).getMontantEnchere()) {
                throw new ENIEncheresException(Message.MONTANT_ENCHERE_INSUFFISANT.showMsg());
        }

        // Ajout article a enchere et inversement
        enchere.setArticle(article);
        enchereListFromArticle.add(enchere);

        // Ajout utilisateur a enchere et inversement
        enchere.setUtilisateur(utilisateur);
        List<Enchere> enchereListFromUtilisateur = enchereService.getEncheresByUser(utilisateur);
        enchereListFromUtilisateur.add(enchere);

        // Initialisation date enchere a la date du jour
        enchere.setDateEnchere(LocalDate.now());

        // Si premiere enchere, passage de l'article a l'etat "en cours" (2)
        if (article.getEtatVente() == 1) {
            article.setEtatVente(2);
        }

        // Enregistrement enchere en DB
        enchereService.addEnchere(enchere);
        return enchere;
    }

}
