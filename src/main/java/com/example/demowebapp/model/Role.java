package com.example.demowebapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "id")
    private Set<User> users;

    public Role(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}