package fr.eni.eniencheres.service;

import fr.eni.eniencheres.bo.Retrait;

import java.util.List;

public interface RetraitService {


    public void addRetrait (Retrait retrait);


    public List<Retrait> listRetrait();

    public Retrait getRetraitById(long id);
}
