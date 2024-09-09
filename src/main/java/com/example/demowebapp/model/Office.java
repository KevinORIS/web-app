package com.example.demowebapp.model;

import lombok.Data;

@Data
public class Office {

    private int officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
}
