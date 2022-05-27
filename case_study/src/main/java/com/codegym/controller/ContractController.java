package com.codegym.controller;

import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;


    @GetMapping()
    public String goListContract(Model model,
                                 @PageableDefault(value = 5) Pageable pageable) {

        model.addAttribute("contracts", this.contractService.findAll(pageable));

        return "contract/contract-list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("employees", this.employeeService.findAll());
        model.addAttribute("customers", this.customerService.findAll());
        model.addAttribute("services", this.serviceService.findAll());
        model.addAttribute("contractDto", new ContractDto());

        return "contract/contract-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDto contractDto,
                         BindingResult bindingResult,
                         Model model) {
        new ContractDto().validate(contractDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employees", this.employeeService.findAll());
            model.addAttribute("customers", this.customerService.findAll());
            model.addAttribute("services", this.serviceService.findAll());
            return "contract/contract-create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.create(contract);
        }

        return "redirect:/contracts";
    }

    @GetMapping("/use-service")
    public String goList(Model model){
        model.addAttribute("useService", this.contractService.getList());

        return "contract/list";
    }
}
