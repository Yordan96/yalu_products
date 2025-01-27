package com.yalutec.products.service;

import com.yalutec.products.entity.Product;
import com.yalutec.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;



    public ProductService(ProductRepository repository, KafkaTemplate<String, String> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Mono<Product> createProduct(Product product) {
        return repository.save(product)
                .doOnSuccess(savedProduct -> kafkaTemplate.send("product-events", savedProduct.toString()));
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
