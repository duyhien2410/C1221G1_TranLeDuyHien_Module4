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
    public Page<Customer> findAllAndSearch1(String name, String email, String type, Pageable pageable) {
        return this.customerRepository.findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeId(
                name, email, Integer.parseInt(type), pageable
        );
    }

    @Override
    public Page<Customer> findAllAndSearch2(String name, String email, Pageable pageable) {
        return this.customerRepository.findAllByCustomerNameContainingAndAndCustomerEmailContaining(name, email, pageable);
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
