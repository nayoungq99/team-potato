package com.example.shop.product.repository;

import com.example.shop.product.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 👈 JpaProductRepository에 @Primary가 있으므로, 얘는 대기 구현체가 됩니다.
public class MemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> store = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Product findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : store.values()) {
            if (product.getName().equals(name)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            sequence++;
            product.setId(sequence); // Product 엔티티에 setId가 구현되어 있으므로 잘 작동합니다.
        }
        store.put(product.getId(), product);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}