package fr.eni.eniencheres.converter;

import fr.eni.enchere.trainingenchere.Bo.Article;
import fr.eni.enchere.trainingenchere.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component

public class ArticleConverter implements Converter<String, Article> {


    @Autowired
    ArticleService articleService;



    @Override

    public Article convert(String idAuFormatTexte) {
        long id = Integer.parseInt(idAuFormatTexte);
        return articleService.getArticleById(id);
    }
}
