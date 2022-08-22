package fr.eni.eniencheres.api;


import fr.eni.eniencheres.bo.Retrait;
import fr.eni.eniencheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/retraits")

public class RetraitRestController {



    @Autowired
    private RetraitService retraitService;


    @GetMapping
    public List<Retrait> getlistRetrait(){return retraitService.listRetrait();}

    @GetMapping("{id}")
    public Retrait getRetraitById(@PathVariable long id) {return retraitService.getRetraitById(id);}

    @PostMapping

    public Retrait postRetrait(@RequestBody Retrait retrait) throws Exception {
        retraitService.addRetrait(retrait);

        return retrait;
    }
}
