package fr.eni.eniencheres.api;

import fr.eni.eniencheres.bo.Categorie;
import fr.eni.eniencheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategorieRestController {

    @Autowired
    CategorieService categorieService;

    @GetMapping
    public List<Categorie> getlistCategories(){return categorieService.listCategorie();}


    @GetMapping("{id}")
     public Categorie getCategorieById(@PathVariable long id) {return categorieService.getCategorieById(id);}

    @PostMapping

    public Categorie postCategorie(@RequestBody Categorie categorie) throws Exception {
            try {  categorieService.addCategorie(categorie);}

            catch (Exception e )
            {
                throw new ResponseStatusException(
                        401, "Categorie deja existante",e);
            }

            return categorie;
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable("id") Long id) {
        if (id != null) {
            categorieService.deleteCategorieeById(id);
        }
    }

}
