package com.example.products.productsservice.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Getter
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String category;
    private String color;
    private String availability;
    private double discount;
    private double rating;
    private String warranty;
    private String dimensions;
    private String weight;


}