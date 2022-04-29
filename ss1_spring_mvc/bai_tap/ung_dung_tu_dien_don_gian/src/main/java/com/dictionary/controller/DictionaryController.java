package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping(value = "/goHome")
    public String goHome() {
        return "homepage";
    }

    @GetMapping(value = "/translate")
    public String translate(@RequestParam String eng,
                            Model model) {
        model.addAttribute("result",this.dictionaryService.translate(eng));

        return "result";
    }
}
