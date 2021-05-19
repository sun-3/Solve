package com.solve.Solve.controller;

import com.solve.Solve.model.Comment;
import com.solve.Solve.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping("/blogs/{blogId}/comments")
    public Comment addComment(@RequestBody @Valid Comment comment) {
        return service.saveComment(comment);
    }

    @GetMapping("/blogs/{blogId}/comments")
    public List<Comment> getCommentsByBlogId(@PathVariable int blogId) {
        return service.getCommentsByBlogId(blogId);
    }

    @GetMapping("/blogs/{blogId}/comments/{parentId}")
    public List<Comment> getNestedCommentsByParentId(@PathVariable int parentId) {
        return service.getNestedCommentsByParentId(parentId);
    }
}
