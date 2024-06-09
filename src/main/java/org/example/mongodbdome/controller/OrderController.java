package org.example.mongodbdome.controller;

import org.example.mongodbdome.model.Order;
import org.example.mongodbdome.model.User;
import org.example.mongodbdome.repository.OrderRepository;
import org.example.mongodbdome.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Faim
 * @create 2024/6/7 17:14
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long userId, @RequestBody List<String> productIds) {
        Order order = new Order();
        order.setUserId(userId);
        order.setProductIds(productIds);
        order.setOrderDate(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(orderRepository.findByUserId(userId));
    }
}
