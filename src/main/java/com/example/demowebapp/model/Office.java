package com.example.demowebapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Office")
@Table(name = "offices")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int officeCode;
    @Column (nullable = false)
    private String city;
    @Column (nullable = false)
    private String phone;
    @Column (nullable = false)
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
}
