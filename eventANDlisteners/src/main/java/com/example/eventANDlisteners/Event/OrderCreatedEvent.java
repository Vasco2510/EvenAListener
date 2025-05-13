package com.example.eventANDlisteners.Event;

import lombok.Data;


@Data
public class OrderCreatedEvent {
    private Long id;
    private String email;
    private String product;

    public OrderCreatedEvent(Long id, String email, String product) {
        this.id = id;
        this.email = email;
        this.product = product;
    }

}

