package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SubscriptionServicesImpl;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@Transactional
@SpringBootTest
public class TestModif {
    private static final Logger logger = Logger.getLogger(TestModif.class.getName());
    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @Mock
    private ISkierRepository skierRepository;

    private SubscriptionServicesImpl subscriptionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        subscriptionService = new SubscriptionServicesImpl(subscriptionRepository, skierRepository);
    }

    @Test
    public void testUpdateSubscription() {
        Long subscriptionId = 1L;
        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.SEMESTRIEL);
        subscription.setPrice(10000f);
        subscription.setNumSub(subscriptionId);
        subscription.setStartDate(LocalDate.now());

        when(subscriptionRepository.save(Mockito.any(Subscription.class))).thenReturn(subscription);
        when(subscriptionRepository.findById(subscriptionId)).thenReturn(Optional.of(subscription));


        Subscription updatedSubscription = subscriptionService.updateSubscription(subscription);

        assertNotNull(updatedSubscription);
        assertEquals(subscriptionId, updatedSubscription.getNumSub());
        logger.info("TestUpdate-after : =>  "+updatedSubscription.toString());
    }
}
