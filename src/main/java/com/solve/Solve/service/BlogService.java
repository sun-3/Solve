package com.solve.Solve.service;

import com.solve.Solve.dao.BlogRepository;
import com.solve.Solve.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    public Blog saveBlog(Blog blog) {
        return repository.save(blog);
    }

    public List<Blog> getBlogs() {
        return repository.findAll();
    }

    public Blog getBlogById(int id) {
        return repository.findById(id).orElseThrow(null);
    }

    public Blog updateBlog(Blog blog) {
        Blog existing = repository.getOne(blog.getId());
        existing.setAuthors(blog.getAuthors());
        existing.setTitle(blog.getTitle());
        existing.setText(blog.getText());
        existing.setPostedAt(existing.getPostedAt());
        return repository.save(existing);
    }

    public String deleteBlog(int id) {
        repository.deleteById(id);
        return "Blog deleted";
    }
}
