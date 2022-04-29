package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private IConvertService convertService;

    @GetMapping(value = "/goHome")
    public String goHomePage(){
        return "homepage";
    }

    @GetMapping(value = "/convert")
    public String convertUsd(@RequestParam Double usd,
                             Model model){
        model.addAttribute("result",this.convertService.covert(usd));

        return "result";
    }

}
