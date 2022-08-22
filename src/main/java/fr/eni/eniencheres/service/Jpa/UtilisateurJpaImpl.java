package fr.eni.eniencheres.service.Jpa;

import fr.eni.enchere.trainingenchere.Bo.Utilisateur;
import fr.eni.enchere.trainingenchere.repository.UtilisateurRepository;
import fr.eni.enchere.trainingenchere.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j
public class UtilisateurJpaImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository  utilisateurRepository;




    @Override
    public void addUtilisateur(Utilisateur utilisateur)  {
        utilisateurRepository.save(utilisateur);

    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getMembreByPseudo(String pseudo) {
        return utilisateurRepository.findById(pseudo).get();
    }
}
