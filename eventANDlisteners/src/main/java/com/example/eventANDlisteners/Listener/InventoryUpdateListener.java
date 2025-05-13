package com.example.eventANDlisteners.Listener;

import com.example.eventANDlisteners.Event.OrderCreatedEvent;
import com.example.eventANDlisteners.Repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LoggerFactory.getLogger(InventoryUpdateListener.class);

    @Autowired
    private OrderRepository orderRepository;

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {

        orderRepository.findById(event.getId()).ifPresent(order -> {
            if (order.getStock() != null && order.getStock() > 0) {
                order.setStock(order.getStock() - 1);
                orderRepository.save(order);
                logger.info("Stock actualizado para el producto '{}': nuevo stock = {}", order.getProducts(), order.getStock());
            } else {
                logger.warn("No hay stock disponible para el producto '{}'", order.getProducts());
            }
        });
    }
}
