package org.example.mongodbdome.service;

import org.example.mongodbdome.model.Order;
import org.example.mongodbdome.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Faim
 * @create 2024/6/7 17:14
 */
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
