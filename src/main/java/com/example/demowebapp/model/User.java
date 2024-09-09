package com.example.demowebapp.model;

import lombok.*;

import java.sql.Timestamp;

@Data
public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    private Role role; // ???

    private boolean isActive; // Not active by default
    private Timestamp createdTs;
    private Timestamp updatedTs;

}
