package fr.eni.eniencheres.service;

import fr.eni.eniencheres.bo.Categorie;

import java.util.List;

public interface CategorieService {


public void addCategorie (Categorie categorie) throws Exception;

public List<Categorie> listCategorie();

public Categorie getCategorieById(long id);
}
