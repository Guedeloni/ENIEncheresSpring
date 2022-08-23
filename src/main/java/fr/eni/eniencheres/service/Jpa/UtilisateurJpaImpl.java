package fr.eni.eniencheres.service.Jpa;

import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.repository.UtilisateurRepository;
import fr.eni.eniencheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurJpaImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public void addUtilisateur(Utilisateur utilisateur)  {
        utilisateurRepository.save(utilisateur);

    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurByPseudo(String pseudo) {
        return utilisateurRepository.findByPseudo(pseudo);
    }

    @Override
    public Utilisateur getUtilisateurById(long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public void deleteUtilisateurById(Long id) {
        utilisateurRepository.deleteById(id);

    }


}
