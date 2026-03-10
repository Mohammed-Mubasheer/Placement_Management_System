package com.ewit.placement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //
    
    @NotBlank(message = "Student Name cannot be empty")
    private String name;
    
    @Min(value = 1, message = "Roll number must be valid")
    private Long roll;
    
    @NotBlank(message = "Qualification is required")
    private String qualification;
    
    @NotBlank(message = "Course is required")
    private String course;
    
    @Min(value = 2024, message = "Year must be 2024 or later")
    private int year;
    
    @NotNull(message = "Hall Ticket Number is mandatory") // Rule 6
    @Column(unique = true)
    private Long hallTicketNo;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "college_id")
    private College college; //

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificate_id")
    private Certificate certificate; //

    // Getters and Setters
    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public Student() {}

    public Student(String name, Long roll, String qualification, String course, int year, Long hallTicketNo) {
        this.name = name;
        this.roll = roll;
        this.qualification = qualification;
        this.course = course;
        this.year = year;
        this.hallTicketNo = hallTicketNo;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRoll() {
		return roll;
	}
	public void setRoll(Long roll) {
		this.roll = roll;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Long getHallTicketNo() {
		return hallTicketNo;
	}
	public void setHallTicketNo(Long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
    
    
}