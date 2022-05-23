package com.codegym.controller;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.repository.customer.ICustomerTypeRepository;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping()
    public String goListCustomer(Model model,
                                 @PageableDefault(value = 5) Pageable pageable) {

        model.addAttribute("customer", this.customerService.findAll(pageable));

        return "customer/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("customerType", this.customerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());

        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", this.customerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.create(customer);
        }

        return "redirect:/customers";
    }


}
