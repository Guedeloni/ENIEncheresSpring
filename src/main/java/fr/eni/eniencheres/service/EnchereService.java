package fr.eni.eniencheres.service;

import fr.eni.eniencheres.bo.Enchere;
import fr.eni.eniencheres.bo.Utilisateur;

import java.util.List;

public interface EnchereService {

    public void addEnchere (Enchere enchere);

    public List <Enchere> listEnchere();

    public Enchere getEnchereById(long id);

    List<Enchere> getEncheresByUser(Utilisateur utilisateur);
}
