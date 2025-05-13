package com.example.eventANDlisteners.Listener;

import com.example.eventANDlisteners.Event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationListener.class);

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        logger.info("Enviando correo de confirmación a: " + event.getEmail());
    }
}