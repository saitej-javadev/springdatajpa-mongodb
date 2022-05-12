package com.saitej.springdatajpa.mongodb;

import com.saitej.springdatajpa.mongodb.model.Product;
import com.saitej.springdatajpa.mongodb.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringdatajpaMongodbApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSave() {
        Product product = new Product();
        product.setName("Mac Book Pro");
        product.setPrice(2000f);

        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct);
        assertNotNull(savedProduct);
    }

    @Test
    void testFindAll() {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        assertEquals(2,products.size());
    }

    @Test
    void testDelete() {
        productRepository.deleteById("627d43f73daa5c382ba7cc0f");
        Optional<Product> retrievedProduct = productRepository.findById("627d43f73daa5c382ba7cc0f");
        assertEquals(Optional.empty(),retrievedProduct);
    }
}
