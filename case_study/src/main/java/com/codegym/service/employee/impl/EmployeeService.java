package com.codegym.service.employee.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllAndSearch1(String name, String email, String division, Pageable pageable) {
        return this.employeeRepository.findAllByEmployeeNameContainingAndEmployeeEmailContainingAndDivisionId_DivisionId(
                name, email, Integer.parseInt(division), pageable
        );
    }

    @Override
    public Page<Employee> findAllAndSearch2(String name, String email, Pageable pageable) {
        return this.employeeRepository.findAllByEmployeeNameContainingAndEmployeeEmailContaining(name, email, pageable);
    }

    @Override
    public void create(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }
}
