package com.example.service.customer;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<CustomerType> findAllCustomerType();

    Customer save(Customer customer);

    Optional<Customer> findCustomerById(int id);

    void deleteCustomerById(int id);

    Page<Customer> findAllCustomer(Pageable pageable);

    Page<Customer> findAllCustomerByKeyword(String keyword, Pageable pageable);
}
