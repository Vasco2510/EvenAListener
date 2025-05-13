package com.example.eventANDlisteners.Controller;


import com.example.eventANDlisteners.Entity.Product;
import com.example.eventANDlisteners.Entity.ProductRequest;
import com.example.eventANDlisteners.Repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        Product product = new Product(productRequest.getName(), productRequest.getStock());
        return productRepository.save(product);
    }
}
