package com.ewit.placement.service;

import com.ewit.placement.entity.Student;
import com.ewit.placement.exception.StudentNotFoundException;
import com.ewit.placement.entity.Certificate;
import com.ewit.placement.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepo;

    // --- 1. Add Student ---
    @Override
    public Student addStudent(Student student) {
        
        return studentRepo.save(student);
    }

    // --- 2. Update Student ---
    @Override
    public Student updateStudent(Student student) {
        // Business Logic: Check if student exists before updating
        if (student.getId() != null && studentRepo.existsById(student.getId())) {
            return studentRepo.save(student);
        }
        return null; // Or throw exception based on your preference
    }

    // --- 3. Search by ID ---
    @Override
    public Student searchStudentById(long id) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    // --- 4. Search by Hall Ticket (Specific Requirement) ---
    @Override
    public Student searchStudentByHallTicket(long ticketNo) {
    	
    	return studentRepo.findById(ticketNo).orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + ticketNo));
    }

    // --- 5. Delete Student ---
    @Override
    public boolean deleteStudent(long id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }

 // --- Placeholder Implementations for Certificate ---
    // we return true here to satisfy the Interface contract.
    
    @Override
    public boolean addCertificate(Certificate certificate) {
        // In the future, you will inject CertificateRepository here and save it.
        return true; 
    }

    @Override
    public boolean updateCertificate(Certificate certificate) {
        // In the future, you will verify the ID and save.
        return true;
    }
}
