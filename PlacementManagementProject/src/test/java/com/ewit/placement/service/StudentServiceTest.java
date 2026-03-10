package com.ewit.placement.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import jakarta.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//Use this if the old import fails
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ewit.placement.entity.Student;
import com.ewit.placement.repository.IStudentRepository;
import com.ewit.placement.exception.StudentNotFoundException;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private IStudentService studentService;

    @MockitoBean
    private IStudentRepository repository;

    // --- FIX 1: Match the EXACT message from your Student.java ---
    @Test
    public void testAddStudent_WithInvalidData() {
        Student invalidStudent = new Student("", 101L, "BE", "CSE", 2025, 12345L);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Student>> violations = validator.validate(invalidStudent);

        assertFalse(violations.isEmpty());
        
        // UPDATED: Changed "Student Name is mandatory" to "Student Name cannot be empty"
        // This matches what is written in your Student.java entity
        assertEquals("Student Name cannot be empty", violations.iterator().next().getMessage());
    }

    // --- FIX 2: Use assertThrows to CATCH the exception ---
    @Test
    public void testSearchStudent_NotFound() {
        // Mock repo to return empty
        when(repository.findById(999L)).thenReturn(Optional.empty());

        // This line tells JUnit: "I EXPECT this to fail with StudentNotFoundException"
        // If it throws the exception, the test PASSES.
        Exception exception = assertThrows(StudentNotFoundException.class, () -> {
            studentService.searchStudentById(999L);
        });

        // Optional: Verify the message is correct
        assertTrue(exception.getMessage().contains("Student not found with id"));
    }
    
    // --- FIX 3: Use assertThrows for Hall Ticket too ---
    @Test
    public void testSearch_InvalidHallTicket() {
        // Mock repo to return null
        when(repository.findByHallTicketNo(0L)).thenReturn(null);
        
        assertThrows(StudentNotFoundException.class, () -> {
            studentService.searchStudentByHallTicket(0L);
        });
    }
}