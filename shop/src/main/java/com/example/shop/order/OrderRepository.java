package com.example.shop.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findAll() {
        return em.createQuery("SELECT m FROM Order m", Order.class)
                .getResultList();
    }

    public Order findByOrderNumber(String OrderNumber){
        List<Order> result = em.createQuery(
                "SELECT m FROM m WHERE m.OrderNumber = :OrderNumber", Order.class
        ).setParameter("OrderNumber",OrderNumber).getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    public void save(Order order) {em.persist(order); }

    public void deleteById(Long id){
        Order order = em.find(Order.class, id);
        em.remove(order);
    }
}
