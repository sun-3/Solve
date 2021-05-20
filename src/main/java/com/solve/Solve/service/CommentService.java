package com.solve.Solve.service;

import com.solve.Solve.dao.CommentRepository;
import com.solve.Solve.exception.Errors;
import com.solve.Solve.exception.IdMismatchException;
import com.solve.Solve.exception.InvalidDataException;
import com.solve.Solve.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;
    @Autowired
    private BlogService blogService;

    public Comment saveComment(int blogId, Comment comment) {
        if (comment.getPostedAt() == null) {
            comment.setPostedAt(new Date(System.currentTimeMillis()));
        }

        if (isValidComment(comment, blogId)) {
            return repository.save(comment);
        } else {
            throw new InvalidDataException(Errors.ERR_INVALID_DATA_COMMENT);
        }
    }

    public List<Comment> getCommentsByBlogId(int blogId) {
        return repository.findByBlogId(blogId);
    }

    public List<Comment> getNestedCommentsByParentId(int parentId) {
        return repository.findByParentId(parentId);
    }

    private boolean isValidComment(Comment comment, int blogId) {
        if (blogId != comment.getBlogId()) {
            throw new IdMismatchException(Errors.ERR_ID_MISMATCH_COMMENT_BLOG_ID);
        } else if (!blogService.existsById(blogId)) {
            throw new InvalidDataException(Errors.ERR_INVALID_DATA_COMMENT_BLOG_ID_NOT_FOUND);
        }

        return true;
    }
}
