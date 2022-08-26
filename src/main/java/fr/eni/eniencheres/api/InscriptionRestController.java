package fr.eni.eniencheres.api;

import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/inscription")
public class InscriptionRestController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public Utilisateur postInscription(@RequestBody Utilisateur utilisateur) throws Exception {
       utilisateurService.addUtilisateur(utilisateur);
       return utilisateur;
    }
}
