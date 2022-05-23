package com.codegym.controller;

import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/customers")
public class CustomerController {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @GetMapping()
    public String goListCustomer(Model model,
                                 @PageableDefault(value = 5) Pageable pageable) {

        model.addAttribute("customer", this.customerRepository.findAll(pageable));

        return "customer/list";
    }


}
