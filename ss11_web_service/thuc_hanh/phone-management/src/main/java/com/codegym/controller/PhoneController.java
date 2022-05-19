package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneController {
    @GetMapping("/")
    public String showIndex() {
        return "/index";
    }
}
