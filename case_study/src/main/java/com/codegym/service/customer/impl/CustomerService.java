package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public void create(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }
}
