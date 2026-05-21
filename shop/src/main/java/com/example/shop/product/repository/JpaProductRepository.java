package com.example.shop.product.repository;

import com.example.shop.product.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaProductRepository implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll(){
        return em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    @Override
    public List<Product> findByName(String name){
        return em.createQuery(
                "SELECT p FROM Product p WHERE p.name = :name", Product.class
        ).setParameter("name", name).getResultList();
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    @Override
    public void deleteById(Long id) {
        Product product = findById(id);
        if (product != null) {
            em.remove(product);
        }
    }

}