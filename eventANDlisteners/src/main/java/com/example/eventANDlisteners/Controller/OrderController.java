package com.example.eventANDlisteners.Controller;

import com.example.eventANDlisteners.Entity.Order;
import com.example.eventANDlisteners.Entity.OrderRequest;
import com.example.eventANDlisteners.Event.OrderCreatedEvent;
import com.example.eventANDlisteners.Repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    public OrderController(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRequest orderRequest) {

        Order order = new Order(orderRequest.getOrderId(), orderRequest.getEmail(), orderRequest.getProduct());

        orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(order.getOrderId(), order.getEmail(), order.getProduct());
        eventPublisher.publishEvent(event);
    }
}

