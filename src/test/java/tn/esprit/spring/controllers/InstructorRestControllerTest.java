package tn.esprit.spring.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.services.IInstructorServices;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class InstructorRestControllerTest {

    @Mock
    private IInstructorServices instructorServices;

    @InjectMocks
    private InstructorRestController instructorRestController;

    @Test
    public void testGetAllInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        // Add test instructors to the list

        Mockito.when(instructorServices.retrieveAllInstructors()).thenReturn(instructors);
        Assertions.assertEquals(instructors, instructorRestController.getAllInstructors());
    }

    // Write similar tests for other controller methods like addInstructor, updateInstructor, etc.
}
