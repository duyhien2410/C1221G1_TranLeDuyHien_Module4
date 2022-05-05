package com.codegym.controller;

import com.codegym.model.Declaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeclarationController {
    @GetMapping(value = "/declarations")
    public String goDeclarations(Model model){
        model.addAttribute("declaration",new Declaration());
        return "declaration";
    }

    @PostMapping(value = "/declarations")
    public String declarations(@ModelAttribute Declaration declaration,
                               Model model){
        model.addAttribute("declaration",declaration);
        return "declaration";
    }

}
