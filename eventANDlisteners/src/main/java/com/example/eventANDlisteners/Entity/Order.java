package com.example.eventANDlisteners.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String email;
    private String products;

    public Order() {}

    public Order(String orderId, String email, String product) {
        this.orderId = orderId;
        this.email = email;
        this.products = product;
    }
}
