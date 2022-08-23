package fr.eni.eniencheres.api;


import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Categorie;
import fr.eni.eniencheres.bo.Retrait;
import fr.eni.eniencheres.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/articles")
public class ArticleRestController {


    @Autowired
    ArticleService articleService;




    @GetMapping
    public List<Article> getlistArticle(){return articleService.listeArticle();}

    @GetMapping("{id}")
    public Article getArticleById(@PathVariable long id) {return articleService.getArticleById(id);}

    @PostMapping

    public Article postArticle(@RequestBody Article article) throws Exception {

        articleService.addArticle(article);

        return article;
    }
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        if(id !=null) {
            articleService.deleteArticleById(id);
        }
    }
}
