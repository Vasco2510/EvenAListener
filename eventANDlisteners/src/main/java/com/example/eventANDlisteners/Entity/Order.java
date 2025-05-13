package com.example.eventANDlisteners.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String email;
    private String product;

    public Order() {}

    public Order(String orderId, String email, String product) {
        this.orderId = orderId;
        this.email = email;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getEmail() {
        return email;
    }

    public String getProduct() {
        return product;
    }
}
