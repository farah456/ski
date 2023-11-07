package tn.esprit.spring.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.services.PisteServicesImpl;

public class PisteServiceTest {

    @InjectMocks
    private PisteServicesImpl pisteService;

    @Mock IPisteRepository pisteRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePiste() {
        Piste piste = new Piste();
        piste.setNumPiste(1L);
        piste.setNamePiste("Slope 1");
        piste.setColor(Color.BLUE);
        piste.setLength(1000);
        piste.setSlope(30);
        Set<Skier> skiers = new HashSet<>();
        // Ajoutez des skieurs à la piste si nécessaire
        piste.setSkiers(skiers);

        when(pisteRepository.save(piste)).thenReturn(piste);

        Piste savedPiste = pisteService.addPiste(piste);

        assertEquals("Slope 1", savedPiste.getNamePiste());
        // Ajoutez d'autres assertions en fonction de vos besoins
    }

    @Test
    public void testGetPisteById() {
        Piste piste = new Piste();
        piste.setNumPiste(1L);
        piste.setNamePiste("Slope 1");

        when(pisteRepository.findById(1L)).thenReturn(Optional.of(piste));

        Piste retrievedPiste = pisteService.retrievePiste(1L);

        assertEquals("Slope 1", retrievedPiste.getNamePiste());
        // Ajoutez d'autres assertions en fonction de vos besoins
    }



   /* @Test
    public void testDeletePiste() {
        Piste piste = new Piste();
        piste.setNumPiste(1L);
        piste.setNamePiste("Slope 1");

        pisteService.removePiste(1L);

        verify(pisteRepository, times(1)).deleteById(1L);
    }

    // Vous pouvez ajouter d'autres méthodes de test pour les autres opérations CRUD si nécessaire.
*/
   @Test
   public void testDeletePiste() {
       // Identifiant de la piste à supprimer
       Long pisteId = 1L;

       // Créez une piste simulée pour la méthode findById
       Piste piste = new Piste();
       piste.setNumPiste(pisteId);
       piste.setNamePiste("Piste A");

       // Simulez le comportement de findById dans le repository
       when(pisteRepository.findById(pisteId)).thenReturn(java.util.Optional.of(piste));

       // Appelez la méthode à tester
       pisteService.removePiste(pisteId);

       // Vérifiez que la méthode deleteById a été appelée avec l'identifiant de la piste
       verify(pisteRepository, times(1)).deleteById(pisteId);
   }
}
