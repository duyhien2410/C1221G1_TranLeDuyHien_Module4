package com.codegym.service.employee;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAllAndSearch1(String name, String email, String division, Pageable pageable);

    Page<Employee> findAllAndSearch2(String name, String email, Pageable pageable);

    void create(Employee employee);

    void delete(int id);

    Employee findById(int id);
}
