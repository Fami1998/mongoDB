package org.example.mongodbdome.controller;

import org.example.mongodbdome.model.Comment;
import org.example.mongodbdome.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Faim
 * @create 2024/6/7 17:19
 */
@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/{productId}")
    public ResponseEntity<List<Comment>> getCommentsByProductId(@PathVariable String productId) {
        return ResponseEntity.ok(commentRepository.findByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        Comment savedComment = commentRepository.save(comment);
        return ResponseEntity.ok(savedComment);
    }
}
