package com.ewit.placement.controller;

import com.ewit.placement.entity.Student;
import com.ewit.placement.service.IStudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update")
    public Student updateStudent(@Valid @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student searchStudentById(@Valid @PathVariable long id) {
        return studentService.searchStudentById(id);
    }
    
    @GetMapping("/get/hallticket/{ticketNo}")
    public Student searchStudentByHallTicket(@Valid @PathVariable long ticketNo) {
        return studentService.searchStudentByHallTicket(ticketNo);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStudent(@Valid @PathVariable long id) {
        return studentService.deleteStudent(id);
    }
}
