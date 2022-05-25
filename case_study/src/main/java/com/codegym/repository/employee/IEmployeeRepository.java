package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByEmployeeNameContainingAndEmployeeEmailContainingAndDivisionId_DivisionId(
            String name, String email, int division, Pageable pageable);
    Page<Employee> findAllByEmployeeNameContainingAndEmployeeEmailContaining(String name, String email, Pageable pageable);
}
