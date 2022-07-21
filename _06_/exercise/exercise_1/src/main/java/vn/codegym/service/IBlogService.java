package vn.codegym.service;

import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    Blog findById(int id);

    void update(int id, Blog product);

    void remove(int id);
}
