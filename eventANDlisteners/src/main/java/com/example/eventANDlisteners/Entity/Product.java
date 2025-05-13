package com.example.eventANDlisteners.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stock;

    public Product() {}

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int amount) {
        if (this.stock >= amount) {
            this.stock -= amount;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock disponible.");
        }
    }
}

