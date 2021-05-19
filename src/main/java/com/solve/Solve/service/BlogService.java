package com.solve.Solve.service;

import com.solve.Solve.dao.BlogRepository;
import com.solve.Solve.exception.Errors;
import com.solve.Solve.exception.IncompleteJsonException;
import com.solve.Solve.exception.InvalidDataException;
import com.solve.Solve.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.findById(id).orElseThrow(null);
    }

    public Blog updateBlog(Blog blog) {
        if (blog.getPostedAt() == null) {
            blog.setPostedAt(new Date(System.currentTimeMillis()));
        }

        if (isValidBlog(blog)) {
            Blog existing = repository.getOne(blog.getId());
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
        repository.deleteById(id);
        return "Blog deleted";
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
