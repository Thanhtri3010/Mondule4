package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
