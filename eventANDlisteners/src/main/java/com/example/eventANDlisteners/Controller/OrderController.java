package com.example.eventANDlisteners.Controller;

import com.example.eventANDlisteners.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired private ApplicationEventPublisher eventPublisher;

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        eventPublisher.publishEvent(new OrderCreatedEvent(
            order.getId(), order.getEmail(), order.getProducts()));
        return "Order created successfully!";
    }
}
