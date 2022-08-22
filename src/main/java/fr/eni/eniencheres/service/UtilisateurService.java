package fr.eni.eniencheres.service;

import fr.eni.enchere.trainingenchere.Bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {



    public void  addUtilisateur (Utilisateur utilisateur) ;


    public List<Utilisateur> listeUtilisateur();


        public   Utilisateur getMembreByPseudo (String pseudo);
}
