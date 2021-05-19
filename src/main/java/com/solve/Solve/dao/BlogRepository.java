package com.solve.Solve.dao;

import com.solve.Solve.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
