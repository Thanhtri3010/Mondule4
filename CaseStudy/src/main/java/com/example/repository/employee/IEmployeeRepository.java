package com.example.repository.employee;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where employee_name like :keyword",
            nativeQuery = true,
            countQuery = "select * from employee where employee_name like :keyword")
    Page<Employee> findAllEmployeeByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
