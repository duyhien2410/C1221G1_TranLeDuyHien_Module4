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
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public void create(Employee employee) {
        this.employeeRepository.save(employee);
    }
}
