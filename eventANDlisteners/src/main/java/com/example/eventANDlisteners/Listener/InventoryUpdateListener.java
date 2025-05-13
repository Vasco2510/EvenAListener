package com.example.eventANDlisteners.Listener;

import com.example.eventANDlisteners.Entity.Product;
import com.example.eventANDlisteners.Event.OrderCreatedEvent;
import com.example.eventANDlisteners.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    private static final Logger logger = LoggerFactory.getLogger(InventoryUpdateListener.class);
    private final ProductRepository productRepository;

    public InventoryUpdateListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener
    public void onOrderCreated(OrderCreatedEvent event) {
        // Buscar el producto por nombre
        Product product = productRepository.findByName(event.getProduct());

        if (product != null) {
            try {
                // Disminuir el stock del producto
                product.reduceStock(1); // Asumimos que cada pedido es de 1 unidad
                productRepository.save(product); // Guardar el cambio en la base de datos
                logger.info("Stock actualizado para el producto: " + product.getName() + ". Nuevo stock: " + product.getStock());
            } catch (IllegalArgumentException e) {
                logger.error("Error al actualizar el stock del producto: " + product.getName() + ". " + e.getMessage());
            }
        } else {
            logger.error("Producto no encontrado: " + event.getProduct());
        }
    }
}