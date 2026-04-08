package com.example.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll(){
        return em.createQuery("SELECT m FROM Product m", Product.class)
                .getResultList();
    }

    public Product findByProductNumber(String ProductNumber){
        List<Product> result = em.createQuery(
                "SELECT m FROM m WHERE m.ProductNumber = :ProductNumber", Product.class
        ).setParameter("ProductNumber", ProductNumber).getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    public void save(Product product) { em.persist(product); }

    public void deleteById(Long id){
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
}
