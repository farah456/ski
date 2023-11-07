package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SubscriptionServicesImpl;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@Transactional
@SpringBootTest
public class TestGetAll {
    private static final Logger logger = Logger.getLogger(TestGetAll.class.getName());
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
    public void testReadSubscription() {
        Subscription subscription1 = new Subscription();
        Subscription subscription2 = new Subscription();

        List<Subscription> subscriptions = Arrays.asList(subscription1, subscription2);

        when(subscriptionRepository.findAll()).thenReturn(subscriptions);

        List<Subscription> retrievedSubscriptions = subscriptionService.getAllSubscriptions();

        // Assertions
        assertEquals(subscriptions.size(), retrievedSubscriptions.size());
        // You can add more specific assertions based on the expected data.

        logger.info("Test Get All  =>  "+retrievedSubscriptions.toString());
    }
}
