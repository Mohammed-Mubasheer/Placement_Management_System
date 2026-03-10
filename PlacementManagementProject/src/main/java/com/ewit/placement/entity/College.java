package com.ewit.placement.entity;


//Placeholder Class
import jakarta.persistence.*;

@Entity
public class College { 
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
}
