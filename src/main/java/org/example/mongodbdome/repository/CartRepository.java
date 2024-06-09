package org.example.mongodbdome.repository;

import org.example.mongodbdome.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Faim
 * @create 2024/6/7 17:58
 */
public interface CartRepository  extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
