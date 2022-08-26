package fr.eni.eniencheres.service.Jpa;

import fr.eni.eniencheres.bo.Retrait;
import fr.eni.eniencheres.repository.RetraitRepository;
import fr.eni.eniencheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RetraitJpaImpl implements RetraitService {

    @Autowired
    RetraitRepository retraitRepository;

    @Override
    public void addRetrait(Retrait retrait) { retraitRepository.save(retrait);}

    @Override
    public List<Retrait> listRetrait() {
        return retraitRepository.findAll();
    }

    @Override
    public Retrait getRetraitById(long id) {
        return retraitRepository.findById(id).get();
    }
}
