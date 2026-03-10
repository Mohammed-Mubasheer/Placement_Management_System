package com.ewit.placement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StudentNotFoundException(String message) {
        super(message);
    }
    
    public StudentNotFoundException(Long ticketNo) {
        super("Student not found with Hall Ticket Number: " + ticketNo);
    }
}
