package com.solve.Solve.service;

import com.solve.Solve.dao.BlogRepository;
import com.solve.Solve.exception.Errors;
import com.solve.Solve.exception.IncompleteJsonException;
import com.solve.Solve.exception.InvalidDataException;
import com.solve.Solve.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    public Blog saveBlog(Blog blog) {
        if (blog.getPostedAt() == null) {
            blog.setPostedAt(new Date(System.currentTimeMillis()));
        }

        if (isValidBlog(blog)) {
            return repository.save(blog);
        } else {
            throw new InvalidDataException(Errors.ERR_INVALID_DATA_BLOG);
        }
    }

    public List<Blog> getBlogs() {
        return repository.findAll();
    }

    public Blog getBlogById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Errors.ERR_ENTITY_NOT_FOUND_BLOG_PREFIX + id + Errors.ERR_ENTITY_NOT_FOUND_BLOG_SUFFIX));
    }

    public Blog updateBlog(int id, Blog blog) {
        if (blog.getPostedAt() == null) {
            blog.setPostedAt(new Date(System.currentTimeMillis()));
        }

        if (isValidBlog(blog) && id == blog.getId()) {
            Blog existing = repository.findById(blog.getId()).orElseThrow(() -> new EntityNotFoundException(Errors.ERR_ENTITY_NOT_FOUND_BLOG_PREFIX + blog.getId() + Errors.ERR_ENTITY_NOT_FOUND_BLOG_SUFFIX));
            existing.setAuthors(blog.getAuthors());
            existing.setTitle(blog.getTitle());
            existing.setText(blog.getText());
            existing.setPostedAt(existing.getPostedAt());
            return repository.save(existing);
        } else {
            throw new InvalidDataException(Errors.ERR_INVALID_DATA_BLOG);
        }
    }

    public String deleteBlog(int id) {
        if (existsById(id)) {
            repository.deleteById(id);
            return "Blog deleted";
        } else {
            throw new EntityNotFoundException(Errors.ERR_ENTITY_NOT_FOUND_BLOG_PREFIX + id + Errors.ERR_ENTITY_NOT_FOUND_BLOG_SUFFIX);
        }
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    private boolean isValidBlog(Blog blog) {
        for (String author : blog.getAuthors()) {
            if (author == null || author.isEmpty()) {
                throw new IncompleteJsonException(Errors.ERR_INCOMPLETE_JSON_BLOG_AUTHOR_EMPTY);
            }
        }
        return true;
    }
}
