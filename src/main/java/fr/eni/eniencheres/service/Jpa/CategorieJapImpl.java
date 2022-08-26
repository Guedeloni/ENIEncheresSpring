package fr.eni.eniencheres.service.Jpa;

import fr.eni.eniencheres.bo.Categorie;
import fr.eni.eniencheres.repository.CategorieRepository;
import fr.eni.eniencheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public void deleteCategorieeById(Long id) {
        categorieRepository.findById(id);
    }

}
