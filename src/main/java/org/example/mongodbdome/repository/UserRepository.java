package org.example.mongodbdome.repository;

import org.example.mongodbdome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Faim
 * @create 2024/6/7 16:58
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
