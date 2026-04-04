package com.example.shop.order;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //@Transactional
    public Long createOrder(OrderCreateRequest request) {
        Order existingOrder = orderRepository.findByOrderNumber(request.getOrderNumber());
        if (existingOrder != null) {
            throw new RuntimeException("이미 존재하는 주문번호입니다; " + request.getOrderNumber());
        }

        Order order = new Order(
                request.getOrderNumber(),
                request.getmemberId(),
                request.getProductNumber(),
                request.getOrderQuantity()
        );

        orderRepository.save(order);

        return order.getId();
    }

    // @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("없는 주문 입니다.");
        }

        return order;
    }

    //@Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("없는 주문 입니다.");
        }
        orderRepository.deleteById(id);
    }
}
