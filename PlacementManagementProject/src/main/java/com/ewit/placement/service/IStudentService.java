package com.ewit.placement.service;

import com.ewit.placement.entity.Student;
import com.ewit.placement.entity.Certificate;

public interface IStudentService {
    // Operations defined in your Service Interface slide
    
    Student addStudent(Student student);
    Student updateStudent(Student student);
    Student searchStudentById(long id);
    Student searchStudentByHallTicket(long ticketNo);
    boolean deleteStudent(long id);
    
    boolean addCertificate(Certificate certificate);
    boolean updateCertificate(Certificate certificate);
     
}
