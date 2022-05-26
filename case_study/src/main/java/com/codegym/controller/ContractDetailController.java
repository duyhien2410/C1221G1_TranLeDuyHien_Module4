package com.codegym.controller;

import com.codegym.dto.contract.ContractDetailDto;
import com.codegym.dto.contract.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IAttachServiceService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
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
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping()
    public String goListContract(Model model,
                                 @PageableDefault(value = 5) Pageable pageable) {

        model.addAttribute("contractDetails", this.contractDetailService.findAll(pageable));

        return "contract/contract-detail-list";
    }

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("contracts", this.contractService.findAll());
        model.addAttribute("attachService", this.attachServiceService.findAll());

        model.addAttribute("contractDetailDto", new ContractDetailDto());

        return "contract/contract-detail-create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                         BindingResult bindingResult,
                         Model model) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contracts", this.contractService.findAll());
            model.addAttribute("attachService", this.attachServiceService.findAll());

            return "contract/contract-detail-create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.create(contractDetail);
        }

        return "redirect:/contract-detail";
    }
}
