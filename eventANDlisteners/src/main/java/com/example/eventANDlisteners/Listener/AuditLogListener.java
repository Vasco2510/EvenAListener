package com.example.eventANDlisteners.Listener;

import com.example.eventANDlisteners.Event.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {
    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("Registrando pedido en logs. ID: " + event.getId());
    }
}