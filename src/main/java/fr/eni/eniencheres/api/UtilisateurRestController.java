package fr.eni.eniencheres.api;


import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/utilisateurs")

public class UtilisateurRestController {

    @Autowired
    UtilisateurService utilisateurService;


    @GetMapping
    public List<Utilisateur> getListUtilisateur(){
        return utilisateurService.listeUtilisateur();
    }

    @PostMapping
    public Utilisateur postUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception {
        utilisateurService.addUtilisateur(utilisateur);
        return utilisateur;
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable("id") Long id) {
        if(id != null) {
            utilisateurService.deleteUtilisateurById(id);
        }
    }
    @PutMapping("/{id}")
    public void updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(utilisateur);
    }
}
