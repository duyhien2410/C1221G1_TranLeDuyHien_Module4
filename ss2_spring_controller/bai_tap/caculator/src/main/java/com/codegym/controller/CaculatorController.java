package com.codegym.controller;

import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    private ICaculatorService caculatorService;

    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @GetMapping("/caculator")
    public String caculator(@RequestParam(name = "number1") Double number1,
                            @RequestParam(name = "number2") Double number2,
                            @RequestParam(name = "caculator") Character caculator,
                            Model model) {
        model.addAttribute("result", this.caculatorService.caculator(number1, number2, caculator));
        return "index";
    }


}

