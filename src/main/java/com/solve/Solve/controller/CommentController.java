package com.solve.Solve.controller;

import com.solve.Solve.model.Comment;
import com.solve.Solve.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping("/blogs/{blogId}/comments")
    public Comment addComment(@RequestBody Comment comment) {
        return service.saveComment(comment);
    }

    @GetMapping("/blogs/{blogId}/comments")
    public List<Comment> getCommentsByBlogId(@PathVariable int blogId) {
        return service.getCommentsByBlogId(blogId);
    }
}
