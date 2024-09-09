package com.example.demowebapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(name = "name", length = 128, nullable = false)
    private String name;
    @Column(name = "email", length = 128, nullable = false)
    private String email;
    @Column(name = "password", length = 128, nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "is_active", length = 1)
    private boolean isActive;
    @Column(name = "created_ts")
    @CreationTimestamp
    private Timestamp createdTs;
    @Column(name = "updated_ts")
    private Timestamp updatedTs;

}
