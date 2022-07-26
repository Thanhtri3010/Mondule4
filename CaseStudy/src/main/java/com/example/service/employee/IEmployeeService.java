package com.example.service.employee;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Position> findAllPosition();

    List<Division> findAllDivision();

    List<EducationDegree> findAllEducationDegree();

    Employee save(Employee employee);

    Optional<Employee> findEmployeeById(int id);

    void deleteEmployeeById(int id);

    Page<Employee> findAllEmployee(Pageable pageable);

    Page<Employee> findAllEmployeeByKeyword(String keyword, Pageable pageable);
}
