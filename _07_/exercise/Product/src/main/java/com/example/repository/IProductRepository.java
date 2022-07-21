package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "select * from Product where product_name like :name", nativeQuery = true)
    List<Product> findByNameOfProduct(@Param("name") String keyWord);

    Page<Product> findAll(Pageable pageable);
}
