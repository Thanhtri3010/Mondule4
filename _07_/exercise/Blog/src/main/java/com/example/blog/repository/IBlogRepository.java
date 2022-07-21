package com.example.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
