package com.codegym.controller;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.dto.employee.EmployeeDto;
import com.codegym.dto.serivce.ServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;
import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
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
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @GetMapping
    public String goListEmployee(Model model,
                                 @PageableDefault(value = 5) Pageable pageable,
                                 @RequestParam Optional<String> name,
                                 @RequestParam Optional<String> email,
                                 @RequestParam Optional<String> division){
        String nameVal = name.orElse("");
        String emailVal = email.orElse("");
        String divisionVal = division.orElse("");
        Page<Employee> employees = null;
        if (divisionVal.equals("")){
            employees = this.employeeService.findAllAndSearch2(nameVal, emailVal, pageable);
        } else {
            employees = this.employeeService.findAllAndSearch1(nameVal, emailVal, divisionVal, pageable);
        }

        model.addAttribute("divisions", this.divisionService.findAll());
        model.addAttribute("employees", employees);
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("emailVal", emailVal);
        model.addAttribute("divisionVal", divisionVal);

        return "employee/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("divisions", this.divisionService.findAll());
        model.addAttribute("positions", this.positionService.findAll());
        model.addAttribute("educationDegree", this.educationDegreeService.findAll());
        model.addAttribute("employeeDto", new EmployeeDto());

        return "employee/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisions", this.divisionService.findAll());
            model.addAttribute("positions", this.positionService.findAll());
            model.addAttribute("educationDegree", this.educationDegreeService.findAll());
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.create(employee);
        }

        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        this.employeeService.delete(id);

        return "redirect:/employees";
    }

    @GetMapping("/edit")
    public String goUpdate(@RequestParam("id") int id,
                           Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(this.employeeService.findById(id),employeeDto);

        model.addAttribute("divisions", this.divisionService.findAll());
        model.addAttribute("positions", this.positionService.findAll());
        model.addAttribute("educationDegree", this.educationDegreeService.findAll());
        model.addAttribute("employeeDto", employeeDto);
        return "employee/update";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         Model model) {

        new EmployeeDto().validate(employeeDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisions", this.divisionService.findAll());
            model.addAttribute("positions", this.positionService.findAll());
            model.addAttribute("educationDegree", this.educationDegreeService.findAll());
            return "employee/update";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.create(employee);
        }

        return "redirect:/employees";
    }
}
