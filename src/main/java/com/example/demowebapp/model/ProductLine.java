package com.example.demowebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import javax.transaction.Transactional;
import java.util.Set;

@Data
@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;
    @OneToMany(mappedBy = "productLine")
    private Set<Product> products;
}
