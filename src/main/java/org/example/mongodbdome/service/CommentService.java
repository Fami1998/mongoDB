package org.example.mongodbdome.service;

import org.example.mongodbdome.model.Comment;
import org.example.mongodbdome.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Faim
 * @create 2024/6/7 17:18
 */
public class CommentService{
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByProductId(String productId) {
        return commentRepository.findByProductId(productId);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
