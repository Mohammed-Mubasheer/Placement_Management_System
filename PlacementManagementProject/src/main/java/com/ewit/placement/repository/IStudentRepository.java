package com.ewit.placement.repository;

import com.ewit.placement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    // Spring Data JPA will automatically implement this based on the method name
    Student findByHallTicketNo(Long hallTicketNo); // Matches searchStudentByHallTicket
    
    // Standard methods like save(addStudent), deleteById(deleteStudent), 
    // and findById(searchStudentById) are already provided by JpaRepository.
}