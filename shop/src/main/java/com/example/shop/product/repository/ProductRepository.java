package com.example.shop.product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findAll();
    List<Product> findByName(String name);
    void save(Product product);
    void deleteById(Long id);
}
