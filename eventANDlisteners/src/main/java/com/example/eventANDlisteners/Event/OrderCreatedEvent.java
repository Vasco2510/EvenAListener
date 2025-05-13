package com.example.eventANDlisteners.Event;

public class OrderCreatedEvent {
    private String orderId;
    private String email;
    private String product;

    public OrderCreatedEvent(String orderId, String email, String product) {
        this.orderId = orderId;
        this.email = email;
        this.product = product;
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

