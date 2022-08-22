package fr.eni.eniencheres.service.Jpa;


import fr.eni.enchere.trainingenchere.Bo.Categorie;
import fr.eni.enchere.trainingenchere.repository.CategorieRepository;
import fr.eni.enchere.trainingenchere.service.CategorieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class CategorieJapImpl  implements CategorieService {


    @Autowired
    CategorieRepository categorieRepository;


    @Override
    public void addCategorie(Categorie categorie) throws Exception {
        if (categorieRepository.existsByLibelle(categorie.getLibelle())) {
            throw new Exception("catégorie déjà existant");
        }
        // pour sauvegarder en base de donnée à partir du repository : save()
        categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> listCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorieById(long id) {
        return categorieRepository.findById(id).get();
    }
}
