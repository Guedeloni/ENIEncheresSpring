package fr.eni.eniencheres.service.Jpa;

import fr.eni.eniencheres.bo.Enchere;
import fr.eni.eniencheres.bo.Utilisateur;
import fr.eni.eniencheres.repository.EnchereRepository;
import fr.eni.eniencheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EnchereJpaImpl implements EnchereService {

    @Autowired
    EnchereRepository enchereRepository;

    @Override
    public void addEnchere(Enchere enchere) {
        enchereRepository.save(enchere);

    }

    @Override
    public List<Enchere> listEnchere() {
        return enchereRepository.findAll();
    }

    @Override
    public Enchere getEnchereById(long id) {
        return enchereRepository.findById(id).get();
    }

    @Override
    public List<Enchere> getEncheresByUser(Utilisateur utilisateur) {
        return enchereRepository.findByUtilisateurId(utilisateur.getId());
    }
}
