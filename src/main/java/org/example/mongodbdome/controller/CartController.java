package org.example.mongodbdome.controller;

import org.example.mongodbdome.model.Cart;
import org.example.mongodbdome.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Faim
 * @create 2024/6/7 18:03
 */
@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long userId, @RequestBody List<Long> productIds) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
        }
        cart.setProductIds(productIds);
        Cart savedCart = cartRepository.save(cart);
        return ResponseEntity.ok(savedCart);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cartRepository.delete(cart);
        }
        return ResponseEntity.noContent().build();
    }
}
