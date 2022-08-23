package fr.eni.eniencheres.service;

import fr.eni.eniencheres.bo.Article;
import fr.eni.eniencheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    public void  addUtilisateur (Utilisateur utilisateur) ;

    public List<Utilisateur> listeUtilisateur();

    public   Utilisateur getUtilisateurByPseudo (String pseudo);
    public   Utilisateur getUtilisateurById( long id);

    public  void deleteUtilisateurById(Long id);
    public void updateUtilisateur(Utilisateur utilisateur);


}
