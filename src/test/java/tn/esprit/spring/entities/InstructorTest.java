package tn.esprit.spring.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InstructorTest {
    @Test
    public void testInstructorEntity() {
        Instructor instructor = new Instructor();
        instructor.setNumInstructor(1L);
        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        // ... set other properties

        Assertions.assertEquals(1L, instructor.getNumInstructor());
        Assertions.assertEquals("John", instructor.getFirstName());
        Assertions.assertEquals("Doe", instructor.getLastName());
        // ... assert other properties
    }
}