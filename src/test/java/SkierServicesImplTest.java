

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.services.SkierServicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SkierServicesImplTest {

    @InjectMocks
    private SkierServicesImpl skierServices;

    @Mock
    private ISkierRepository skierRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddSkier() {
        // Créer un Skier pour le test
        Skier skier = new Skier();
        skier.setFirstName("John");
        skier.setLastName("Doe");
        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.ANNUAL);
        skier.setSubscription(subscription);

        // Définir le comportement du mock du repository
        Mockito.when(skierRepository.save(skier)).thenReturn(skier);

        // Appeler la méthode à tester
        Skier savedSkier = skierServices.addSkier(skier);

        // Vérifier que la méthode save du repository a été appelée avec le bon paramètre
        Mockito.verify(skierRepository).save(skier);

        // Vérifier que le Skier renvoyé par la méthode est le même que celui renvoyé par le mock du repository
        assertEquals(skier, savedSkier);

        // Vérifier que le Skier renvoyé par la méthode n'est pas null
        assertNotNull(savedSkier);
    }

    // Ajoutez d'autres méthodes de test pour les autres fonctionnalités de votre service.

}


