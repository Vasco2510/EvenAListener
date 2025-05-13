package com.example.eventANDlisteners.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String products;
    private Integer stock=10;

    public Order() {}

}
