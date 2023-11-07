package tn.esprit.spring.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CourseServicesImplTest {

    @Mock
    private ICourseRepository courseRepositoryMock;

    @InjectMocks
    private CourseServicesImpl courseServices;

    @Test
    void testRetrieveAllCourses() {
        List<Course> expectedCourses = Arrays.asList(new Course(), new Course());

        // Set up behavior for the mock repository
        when(courseRepositoryMock.findAll()).thenReturn(expectedCourses);

        // Call the method you want to test
        List<Course> actualCourses = courseServices.retrieveAllCourses();

        // Verify that the method on the mock repository was called
        verify(courseRepositoryMock).findAll();

        // Perform assertions to check if the actual result matches the expected result
        assertEquals(expectedCourses, actualCourses);
    }

    @Test
     void testAddCourse() {

        Course courseToAdd = new Course();
        courseToAdd.setNumCourse(1L);

        // Set up behavior for the mock repository
        when(courseRepositoryMock.save(any(Course.class))).thenReturn(courseToAdd);

        // Call the method to test
        Course addedCourse = courseServices.addCourse(courseToAdd);

        // Verify that the method on the mock repository was called with the expected argument
        verify(courseRepositoryMock).save(courseToAdd);

        // Perform assertions to check if the actual result matches the expected result
        assertEquals(courseToAdd, addedCourse);
    }

}
