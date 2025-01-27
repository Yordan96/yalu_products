package com.yalutec.products.service;

import com.yalutec.products.entity.Product;
import com.yalutec.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Mono<Product> createProduct(Product product) {
        return repository.save(product);
    }

    public Flux<Product> listProducts() {
        return repository.findAll();
    }

    public Mono<Product> getProductById(String id) {
        return repository.findById(id);
    }

    public Mono<Void> deleteProductById(String id) {
        return repository.deleteById(id);
    }
}
