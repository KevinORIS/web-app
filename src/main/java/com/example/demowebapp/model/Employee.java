package com.example.demowebapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(nullable = false)
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    @ManyToOne
    @JoinColumn(name="officeCode")
    private Office office;
    @ManyToOne
    @JoinColumn(name="reportsTo")
    private Employee employee;
    private String jobTitle;
}
