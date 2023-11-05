package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.repositories.ICourseRepository;
import tn.esprit.spring.repositories.IInstructorRepository;

import java.util.Collections;

@SpringBootTest
public class InstructorServicesImplTest {

    @Mock
    private IInstructorRepository instructorRepository;

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private InstructorServicesImpl instructorServices;

    @Test
    public void testRetrieveAllInstructors() {
        Mockito.when(instructorRepository.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertTrue(instructorServices.retrieveAllInstructors().isEmpty());
    }

    // Write similar tests for other service methods like addInstructor, updateInstructor, etc.
}
