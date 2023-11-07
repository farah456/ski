package tn.esprit.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
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
public class TestSubscription {
    private static final Logger logger = Logger.getLogger(TestSubscription.class.getName());
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
    public void testCreateSubscription() {
        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.MONTHLY);
        subscription.setStartDate(LocalDate.now());
        subscription.setNumSub(((long) 1));
        subscription.setPrice((float)50);
       // Subscription subscription2 = new Subscription();
      //  subscription2.setTypeSub(TypeSubscription.ANNUAL);
       // subscription2.setStartDate(LocalDate.now());
       // subscription2.setNumSub(((long) 2));
      //  subscription2.setPrice((float)500);
        when(subscriptionRepository.save(Mockito.any(Subscription.class))).thenReturn(subscription);
      //  when(subscriptionRepository.save(Mockito.any(Subscription.class))).thenReturn(subscription2);
        Subscription addedSubscription = subscriptionService.addSubscription(subscription);
      //  Subscription addedSubscription2 = subscriptionService.addSubscription(subscription2);
        assertNotNull(addedSubscription.getNumSub());
        assertEquals(subscription.getTypeSub(), addedSubscription.getTypeSub());
        //assertNotNull(addedSubscription2.getNumSub());
       // assertEquals(subscription2.getTypeSub(), addedSubscription2.getTypeSub());
        logger.info("Test Add Subscription :  =>  "+addedSubscription.toString());//"subscription 2"+addedSubscription2);
    }





}

