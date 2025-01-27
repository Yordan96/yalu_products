package com.yalutec.products.repository;

import com.yalutec.products.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
public interface ProductRepository extends ReactiveMongoRepository<Product, String>{
}
