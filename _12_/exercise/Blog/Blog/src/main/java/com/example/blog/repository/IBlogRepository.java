package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByNameContains(String name);
}
