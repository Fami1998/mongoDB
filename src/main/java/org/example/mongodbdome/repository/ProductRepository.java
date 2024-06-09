package org.example.mongodbdome.repository;

import org.example.mongodbdome.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Faim
 * @create 2024/6/7 17:01
 */
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
