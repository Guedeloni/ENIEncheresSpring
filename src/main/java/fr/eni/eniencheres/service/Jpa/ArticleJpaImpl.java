package fr.eni.eniencheres.service.Jpa;

import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.repository.ArticleRepository;
import fr.eni.eniencheres.repository.UtilisateurRepository;
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
    public List<Article> listeArticleByProfilAndSelection(Utilisateur vendeur, int selection) {
        switch (selection) {
            case 1  :
            case 2  :
            case 3  : {
                List<Article> listArticle = articleRepository.findByVendeurAndEtatVente(vendeur, selection);
                return listArticle;
            }
            case 12 :
            case 21 : {
                List<Article> listArticle = articleRepository.findByVendeurAndEtatVenteBetween(vendeur, 1, 2);
                return listArticle;
            }
            case 23 :
            case 32 : {
                List<Article> listArticle = articleRepository.findByVendeurAndEtatVenteBetween(vendeur, 2, 3);
                return listArticle;
            }
            case 13 :
            case 31 : {
                List<Article> listArticle = articleRepository.findByVendeurAndEtatVente(vendeur, 1);
                listArticle.addAll(articleRepository.findByVendeurAndEtatVente(vendeur, 3));
                return listArticle;
            }
            default: return articleRepository.findByVendeur(vendeur);
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
