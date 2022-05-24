package com.codegym.controller;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.dto.serivce.ServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.service.Service;
import com.codegym.service.service.IRentTypeService;
import com.codegym.service.service.IServiceService;
import com.codegym.service.service.IServiceTypeService;
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
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping
    public String goListService(Model model,
                                @PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("services",this.serviceService.findAll(pageable));

        return "service/list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("rentType", this.rentTypeService.findAll());
        model.addAttribute("serviceType", this.serviceTypeService.findAll());
        model.addAttribute("serviceDto", new ServiceDto());

        return "service/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ServiceDto serviceDto,
                         BindingResult bindingResult,
                         Model model) {
        new ServiceDto().validate(serviceDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentType", this.rentTypeService.findAll());
            model.addAttribute("serviceType", this.serviceTypeService.findAll());
            return "service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.create(service);
        }

        return "redirect:/services";
    }
}
