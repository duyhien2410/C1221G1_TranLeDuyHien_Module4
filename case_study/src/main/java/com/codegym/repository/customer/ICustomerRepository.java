package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByCustomerNameContainingAndCustomerEmailContainingAndCustomerTypeId_CustomerTypeId(String name,
                                                                                                            String email,
                                                                                                            int type,
                                                                                                            Pageable pageable);
    Page<Customer> findAllByCustomerNameContainingAndAndCustomerEmailContaining(String name, String email, Pageable pageable);
}
