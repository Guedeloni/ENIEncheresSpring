package fr.eni.eniencheres.api;

import fr.eni.eniencheres.bo.Categorie;
import fr.eni.eniencheres.bo.Enchere;
import fr.eni.eniencheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/encheres")

public class EncheresRestController {


    @Autowired
    EnchereService enchereService;

    @GetMapping
    public List<Enchere> getlistEnchere(){return enchereService.listEnchere();}

    @GetMapping("{id}")
    public Enchere getEnchereById(@PathVariable long id) {return enchereService.getEnchereById(id);}



}
