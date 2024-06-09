package org.example.mongodbdome.repository;

import org.example.mongodbdome.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Faim
 * @create 2024/6/7 17:04
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByProductId(String productId);
}
