package com.solve.Solve.controller;

import com.solve.Solve.model.Blog;
import com.solve.Solve.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class BlogController {
    @Autowired
    private BlogService service;

    @PostMapping("/blogs")
    public Blog addBlog(@RequestBody @Valid Blog blog) {
        return service.saveBlog(blog);
    }

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return service.getBlogs();
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlogById(@PathVariable int id) {
        return service.getBlogById(id);
    }

    @PutMapping("/blogs/{id}")
    public Blog updateBlog(@PathVariable int id, @RequestBody @Valid Blog blog) {
        return service.updateBlog(id, blog);
    }

    @DeleteMapping("/blogs/{id}")
    public String deleteBlog(@PathVariable int id) {
        return service.deleteBlog(id);
    }
}
