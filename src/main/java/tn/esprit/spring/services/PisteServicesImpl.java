package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
<<<<<<< HEAD
import tn.esprit.spring.services.IPisteServices;
=======
>>>>>>> 0137712e0cb160fda55f22b91fa794d9f4508ab6

import java.util.List;
@AllArgsConstructor
@Service
<<<<<<< HEAD
public class PisteServicesImpl implements IPisteServices {
=======
public class PisteServicesImpl implements  IPisteServices{
>>>>>>> 0137712e0cb160fda55f22b91fa794d9f4508ab6

    private IPisteRepository pisteRepository;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }
}
