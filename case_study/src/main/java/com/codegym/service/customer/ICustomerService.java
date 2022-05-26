package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAllAndSearch1(String name, String email, String type, Pageable pageable);

    Page<Customer> findAllAndSearch2(String name, String email, Pageable pageable);

    void create(Customer customer);

    void delete(int id);

    Customer findById(int id);

    List<Customer> findAll();
}
