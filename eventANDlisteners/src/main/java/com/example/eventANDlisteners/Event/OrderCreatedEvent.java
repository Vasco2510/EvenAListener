package com.example.eventANDlisteners.Event;

import lombok.Data;

@Data
public class OrderCreatedEvent {
    private Long orderId;
    private String email;
    private String product;

    public OrderCreatedEvent(Long orderId, String email, String product) {
        this.orderId = orderId;
        this.email = email;
        this.product = product;
    }

}

