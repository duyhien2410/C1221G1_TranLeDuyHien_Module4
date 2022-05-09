package com.codegym.controller;

import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    public String listAll(Model model){
        model.addAttribute("product", iProductService.productAll());

        return "list";
    }


}
