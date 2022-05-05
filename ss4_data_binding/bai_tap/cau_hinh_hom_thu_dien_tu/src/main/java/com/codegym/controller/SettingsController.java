package com.codegym.controller;

import com.codegym.model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SettingsController {

    @GetMapping(value = "/settings")
    public String goSetting(Model model) {
        model.addAttribute("setting", new Settings());

        return "setting";
    }

    @PostMapping(value = "/settings")
    public String setting(@ModelAttribute Settings settings,
                          Model model) {
//        model.addAttribute("setting", settings);
        model.addAttribute(settings);
        return "save";
    }
}
