package com.example.eventANDlisteners.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"order\"")
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


}
