package com.example.demowebapp.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.transaction.Transactional;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    private String productCode;
    private String productName;
    @ManyToOne
    @JoinColumn(name = "productLine")
    private ProductLine productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;
    @Column(name = "MSRP")
    private double msrp;
}
