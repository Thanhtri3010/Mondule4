package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where customer_name like :keyword",
            nativeQuery = true,
            countQuery = "select * from customer where customer_name like :keyword")
    Page<Customer> findAllCustomerByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
