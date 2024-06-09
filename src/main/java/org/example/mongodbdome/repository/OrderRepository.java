package org.example.mongodbdome.repository;

import org.example.mongodbdome.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author Faim
 * @create 2024/6/7 17:02
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
