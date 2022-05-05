package com.codegym.controller;

import com.codegym.model.Upload;
import com.codegym.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UploadController {
    @Autowired
    private IUploadService uploadService;


    @GetMapping("/list")
    public String listTheSong(Model model){
        model.addAttribute("listSong",uploadService.list());
        return "list";

    }

    @GetMapping(value = "/uploads")
    public String goUpload(Model model) {
        model.addAttribute("uploadTheSong", new Upload());

        return "upload";
    }

    @PostMapping(value = "/uploads")
    public String upload(@ModelAttribute Upload upload) {
        this.uploadService.create(upload);
        return "redirect:/list";
    }
}
