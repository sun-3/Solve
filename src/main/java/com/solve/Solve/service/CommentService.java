package com.solve.Solve.service;

import com.solve.Solve.dao.CommentRepository;
import com.solve.Solve.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;

    public Comment saveComment(Comment comment) {
        if (comment.getPostedAt() == null) {
            comment.setPostedAt(new Date(System.currentTimeMillis()));
        }

        return repository.save(comment);
    }

    public List<Comment> getCommentsByBlogId(int blogId) {
        return repository.findByBlogId(blogId);
    }

    public List<Comment> getNestedCommentsByParentId(int parentId) {
        return repository.findByParentId(parentId);
    }
}
