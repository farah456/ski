package tn.esprit.spring.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PisteServiceTestJunit {

    @Autowired
    private PisteServicesImpl pisteService;

    @Autowired
    private IPisteRepository pisteRepository;
    @BeforeEach
    public void setUp() {
        // Avant chaque test, supprimez toutes les pistes de la base de données de test
        pisteRepository.deleteAll();
    }

    @Test
    public void testRetrieveAllPistes() {
        // Enregistrer des pistes dans la base de données de test
        pisteRepository.save(new Piste(null, "Piste1", Color.GREEN, 1000, 20, null));
        pisteRepository.save(new Piste(null, "Piste2", Color.BLUE, 1200, 25, null));

        // Appeler la méthode du service pour récupérer les pistes
        Iterable<Piste> pistes = pisteService.retrieveAllPistes();

        // Vérifier le nombre de pistes récupérées
        long count = pistes.spliterator().getExactSizeIfKnown();
        assertEquals(2, count);
    }

    @Test
    public void testAddPiste() {
        // Créer une nouvelle piste
        Piste piste = new Piste(null, "NewPiste", Color.RED, 1500, 30, null);

        // Ajouter la piste à la base de données de test
        Piste savedPiste = pisteService.addPiste(piste);

        // Récupérer la piste depuis la base de données de test
        Piste retrievedPiste = pisteRepository.findById(savedPiste.getNumPiste()).orElse(null);

        // Vérifier que la piste ajoutée correspond à celle récupérée
        assertEquals(savedPiste.getNumPiste(), retrievedPiste.getNumPiste());
        assertEquals("NewPiste", retrievedPiste.getNamePiste());
    }

    // Les autres méthodes de test (removePiste, retrievePiste) peuvent être implémentées de manière similaire.
}
