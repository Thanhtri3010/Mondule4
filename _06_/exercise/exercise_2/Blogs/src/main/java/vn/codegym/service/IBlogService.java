package vn.codegym.service;

import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);


    void remove(int id);
}
