package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Optional<Product> findById(int id);

    void remove(int id);

    Page<Product> search(String keyword, Pageable pageInfo);
}
