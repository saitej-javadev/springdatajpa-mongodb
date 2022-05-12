package com.saitej.springdatajpa.mongodb.repos;

import com.saitej.springdatajpa.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
