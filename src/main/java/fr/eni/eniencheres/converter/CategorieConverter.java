package fr.eni.eniencheres.converter;


import fr.eni.enchere.trainingenchere.Bo.Categorie;
import fr.eni.enchere.trainingenchere.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component

public class CategorieConverter  implements Converter <String, Categorie>{


    @Autowired
    CategorieService categorieService;

    @Override

    public Categorie convert(String idAuFormatTexte) {
        long id = Integer.parseInt(idAuFormatTexte);
        return categorieService.getCategorieById(id);
    }



}
