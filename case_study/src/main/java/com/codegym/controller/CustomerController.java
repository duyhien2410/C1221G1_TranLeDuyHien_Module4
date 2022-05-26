package com.codegym.controller;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.repository.customer.ICustomerTypeRepository;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping()
    public String goListCustomer(Model model,
                                 @PageableDefault(value = 5) Pageable pageable,
                                 @RequestParam Optional<String> name,
                                 @RequestParam Optional<String> email,
                                 @RequestParam Optional<String> type) {
        String nameVal = name.orElse("");
        String emailVal = email.orElse("");
        String typeVal = type.orElse("");
        Page<Customer> customer = null;
        if (typeVal.equals("")){
            customer = customerService.findAllAndSearch2(nameVal, emailVal, pageable);
        } else {
            customer = customerService.findAllAndSearch1(nameVal, emailVal, typeVal, pageable);
        }

        model.addAttribute("customerType", this.customerTypeService.findAll());
        model.addAttribute("customer", customer);
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("emailVal", emailVal);
        model.addAttribute("typeVal", typeVal);

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
        customerDto.setCustomerCode("KH-"+randomCustomerCode());

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

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        this.customerService.delete(id);

        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam("id") int id,
                           Model model) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(this.customerService.findById(id),customerDto);

        model.addAttribute("customerType", this.customerTypeService.findAll());
        model.addAttribute("customerDto", customerDto);
        return "customer/update";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         Model model) {

        new CustomerDto().validate(customerDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerType", this.customerTypeService.findAll());
            return "customer/update";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.create(customer);
        }

        return "redirect:/customers";
    }

    private String randomCustomerCode() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += randomNumber();
        }
        return result;
    }

    private int randomNumber() {
        int number = (int) Math.round(Math.random() * 9);
        return number;
    }

}
